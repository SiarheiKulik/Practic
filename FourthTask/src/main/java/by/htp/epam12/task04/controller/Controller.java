package by.htp.epam12.task04.controller;

import by.htp.epam12.task04.entity.Candy;
import by.htp.epam12.task04.parser.CandiesDomParser;
import by.htp.epam12.task04.parser.CandiesSAXParser;
import by.htp.epam12.task04.parser.CandiesStAXParser;
import by.htp.epam12.task04.util.ConstatntVariable;
import by.htp.epam12.task04.util.FileNameDivide;
import by.htp.epam12.task04.validator.XmlValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns = {"/upload/"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class Controller extends HttpServlet {

    private final static Logger lOGGER = LogManager.getLogger();

    private static final String CANDIES_VIEW_JSP = "/jsp/candies.jsp";
    private static final String XSD_SCHEME_FILE_PATH = "files\\Task4xsd.xsd";
    private static final String UPLOAD_DIR_NAME = "upload";
    private static final String SLASH_SYMBOL = "\\";
    private static final String DOM_PARSER_STRING = "DOM";
    private static final String SAX_PARSER_STRING = "SAX";
    private static final String STAX_PARSER_STRING = "StAX";
    private static final String PARSER_TYPE_STRING = "parserType";
    private static final String CANDIES_STRING = "candies";
    private static final String PARSER_STRING = "parser";
    private static final String OUT_STRING = "out";
    private static final String CONTENT_STRING = "content";
    private static final long serialVersionUID = 1L;

    public Controller(){}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletContext().getRealPath("/");
        String projectPath = "";
        String selectedParser = req.getParameter(PARSER_STRING);

        for (String line : servletPath.split(ConstatntVariable.SLASH_REG_EXP.getValue())) {
            if (line.equalsIgnoreCase(OUT_STRING)) {
                break;
            }
            projectPath = projectPath.concat(line).concat(SLASH_SYMBOL);

        }

        Part part = req.getPart(CONTENT_STRING);

        String fileName = FileNameDivide.getFileNameByPart(part);
        if (FileNameDivide.isValidFileName(fileName)) {
            String absoluteXmlPath = projectPath + UPLOAD_DIR_NAME + File.separator + fileName;
            String absoluteXsdPath = projectPath + XSD_SCHEME_FILE_PATH;
            part.write(absoluteXmlPath);
            boolean isValidXmlByXsd = new XmlValidator(Paths.get(absoluteXmlPath), Paths.get(absoluteXsdPath))
                    .validate();
            if (!isValidXmlByXsd) {
                resp.sendError(500, "Not valid xml file");
            }

            switch (selectedParser) {
                case DOM_PARSER_STRING: {
                    System.out.println("DOM-Parser");
                    req.setAttribute(PARSER_TYPE_STRING, DOM_PARSER_STRING);
                    CandiesDomParser candiesDomParser = new CandiesDomParser();
                    candiesDomParser.buildListCandies(absoluteXmlPath);
                    List<Candy> candyList = candiesDomParser.getCandies();
                    req.setAttribute(CANDIES_STRING, candyList);
                    break;
                }
                case SAX_PARSER_STRING: {
                    req.setAttribute(PARSER_TYPE_STRING, SAX_PARSER_STRING);
                    CandiesSAXParser candiesSAXParser = new CandiesSAXParser();
                    candiesSAXParser.buildListCandies(absoluteXmlPath);
                    List<Candy> candies = candiesSAXParser.getCandies();
                    req.setAttribute(CANDIES_STRING, candies);
                    break;
                }
                case STAX_PARSER_STRING: {
                    req.setAttribute(PARSER_TYPE_STRING, STAX_PARSER_STRING);
                    CandiesStAXParser candiesStAXParser = new CandiesStAXParser();
                    candiesStAXParser.buildListCandies(absoluteXmlPath);
                    List<Candy>candies = candiesStAXParser.getCandies();
                    req.setAttribute(CANDIES_STRING, candies);
                    break;
                }
                default: {
                    resp.sendError(500);
                }
            }

            try {
                req.getRequestDispatcher(CANDIES_VIEW_JSP).forward(req, resp);
            } catch (UnknownHostException e) {
                lOGGER.log(Level.FATAL, e);
                resp.sendError(500);
            }
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
