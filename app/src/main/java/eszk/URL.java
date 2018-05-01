package eszk;

/**
 * Created by Vitya on 2017. 11. 23..
 */

public enum URL {
    AK47("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/AK-47_1.jpg"),
    AK47a("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/AK-47_2.jpg"),
    BLUEBERRY("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/Blueberry1.png"),
    BLUEBERRYa("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/Blueberry2.png"),
    CHEESE("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/cheese_auto1.jpg"),
    CHEESEa("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/cheese_auto2.jpg"),
    KUSH("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/og_kush1.jpg"),
    KUSHa("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/og_kush2.jpg"),
    KUSHb("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/og_kush3.jpg"),
    CINDRELLA("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/cindrella.jpg"),
    CRITICAL47("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/critical47.jpg"),
    MOBYDICK("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/moby_dick_1.jpg"),
    REDDWARF("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/red_dwarf.jpg"),
    RKS("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/RKS.jpg"),
    RKSa("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/RKS2.jpg"),
    TANGERINE("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/tangerine_dream1.jpg"),
    TANGERINEa("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/tangerine_dream2.jpg"),
    TANGERINEb("http://typo3-v6.softcon-development.at/fileadmin/user_upload/temp/img/tangerine_dream3.png");

    private String url;

    URL(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
