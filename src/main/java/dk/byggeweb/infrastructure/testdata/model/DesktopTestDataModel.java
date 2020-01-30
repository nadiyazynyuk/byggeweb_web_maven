package dk.byggeweb.infrastructure.testdata.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DesktopTestDataModel {

    @XmlElement
    @Getter
    private String userName;

    @XmlElement
    @Getter
    private String password;

    @XmlElement
    @Getter
    private String name;

    @XmlElement
    @Getter
    private String invalidUsername;

    @XmlElement
    @Getter
    private String invalidPassword;

    @XmlElement
    @Getter
    private String newName;

    @XmlElement
    @Getter
    private String testInfo;

    @XmlElement
    @Getter
    private String testFolder;

    @XmlElement
    @Getter
    private String testFileName;

    @XmlElement
    @Getter
    private String fileToUploadPath;

    @XmlElement
    @Getter
    private String firstVersion;

    @XmlElement
    @Getter
    private String secondVersion;

}
