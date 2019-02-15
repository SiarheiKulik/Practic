package by.htp.epam12.task04.entity;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"proteins", "fats", "carbohydrates"}
)

    public class Value {
    public Value(Integer proteins, Integer fats, Integer carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    @XmlElement(
                required = true
        )
        @XmlSchemaType(
                name = "nonNegativeInteger"
        )
        private Integer proteins;
        @XmlElement(
                required = true
        )
        @XmlSchemaType(
                name = "nonNegativeInteger"
        )
        private Integer fats;
        @XmlElement(
                required = true
        )
        @XmlSchemaType(
                name = "nonNegativeInteger"
        )
        private Integer carbohydrates;

        public Value() {
        }

        public Integer getProteins() {
            return this.proteins;
        }

        public void setProteins(Integer value) {
            this.proteins = value;
        }

        public Integer getFats() {
            return this.fats;
        }

        public void setFats(Integer value) {
            this.fats = value;
        }

        public Integer getCarbohydrates() {
            return this.carbohydrates;
        }

        public void setCarbohydrates(Integer value) {
            this.carbohydrates = value;
        }
    }

