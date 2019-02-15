package by.htp.epam12.task04.entity;

import javax.xml.bind.annotation.XmlEnumValue;

public enum ChocolateType {
    @XmlEnumValue(value = "white")
    WHITE,
    @XmlEnumValue(value = "milk")
    MILK,
    @XmlEnumValue(value = "dark")
    DARK
}
