package by.htp.epam12.task04.builder;

import by.htp.epam12.task04.entity.Candy;

import java.util.List;

public interface  XMLBuilder {

    public List<Candy> buildListCandies(String fileName);

}
