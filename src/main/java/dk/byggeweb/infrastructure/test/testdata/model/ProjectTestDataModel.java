package dk.byggeweb.infrastructure.test.testdata.model;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectTestDataModel {

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
    private String projectLink;

    @XmlElement
    @Getter
    private String projectName;

    @XmlElement
    @Getter
    private String folderName;

    @XmlElement
    @Getter
    private String folder1Name;

    @XmlElement
    @Getter
    private String folder2Name;

    @XmlElement
    @Getter
    private String testFileName;

    @XmlElement
    @Getter
    private String testFileName2;

    @XmlElement
    @Getter
    private String fileToUploadPath;

    @XmlElement
    @Getter
    private String fileToUploadPath2;

    @XmlElement
    @Getter
    private String fileV1ToUploadPath;

    @XmlElement
    @Getter
    private String fileV2ToUploadPath;

    @XmlElement
    @Getter
    private String fileV1Content;

    @XmlElement
    @Getter
    private String fileV2Content;

    @XmlElement
    @Getter
    private String fileV1VersionIndex;

    @XmlElement
    @Getter
    private String fileV2VersionIndex;

    @XmlElement
    @Getter
    private String subject;

    @XmlElement
    @Getter
    private String revision;

    @XmlElement
    @Getter
    private String createFolderName;

    @XmlElement
    @Getter
    private String renameFolderName;

    @XmlElement
    @Getter
    private String documentListName;

    @XmlElement
    @Getter
    private String createListName;

    @XmlElement
    @Getter
    private String renameListName;

    @XmlElement
    @Getter
    private String documentListFolderName;

    @XmlElement
    @Getter
    private String versionSetName;

    @XmlElement
    @Getter
    private String createVersionSetName;

    @XmlElement
    @Getter
    private String renameVersionSetName;

    @XmlElement
    @Getter
    private String distributionListName;

}
