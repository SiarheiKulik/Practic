package by.htp.epam12.task04.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"candy"}
)
@XmlRootElement(
        name = "candies"
)
public class Candies {
    @XmlElement(
            required = true
    )
    private List<Candy> candy;

    public Candies() {
    }

    public List<Candy> getCandy() {
        if (this.candy == null) {
            this.candy = new ArrayList();
        }

        return this.candy;
    }
}
