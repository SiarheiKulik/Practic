package by.htp.epam12.task04.builder;

import by.htp.epam12.task04.parser.CandiesDomParser;
import by.htp.epam12.task04.parser.CandiesSAXParser;
import by.htp.epam12.task04.parser.CandiesStAXParser;

public class CandyBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private CandyBuilderFactory() {}

    public static XMLBuilder createCandyBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new CandiesDomParser();
            case SAX:
                return new CandiesSAXParser();
            case STAX:
                return new CandiesStAXParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());


        }
    }

}
