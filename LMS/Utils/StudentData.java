package LMS.Utils;

import java.util.Objects;
import LMS.LibraryExceptions.RollNoNotExistException;

class StudentsData{

    String[][] studentData;

    StudentsData(){
        this.studentData = new String[][]{
                {"22Z201", "ABINAV P"},
                {"22Z202", "ABINAYA B"},
                {"22Z203", "ABINAYA SURESH"},
                {"22Z204", "ABIRAMI M"},
                {"22Z206", "ADISH KUMAR S"},
                {"22Z207", "AJAY S"},
                {"22Z208", "AKSHARAA P"},
                {"22Z209", "ANANDKUMAR N S"},
                {"22Z210", "ANBU SELVAN M"},
                {"22Z211", "ARAVINDHKRISHNAN P"},
                {"22Z212", "ARAVINTH CHERAN K S"},
                {"22Z213", "ARULMOZHI B"},
                {"22Z214", "BRAGADEESH V"},
                {"22Z215", "DHAKKSHIN S R"},
                {"22Z216", "DHEEKSHITHA R"},
                {"22Z217", "ELAKKIYA G"},
                {"22Z218", "GAYATHRI K S"},
                {"22Z219", "GEETHA P K"},
                {"22Z220", "GOBIKA R"},
                {"22Z221", "GOKUL G"},
                {"22Z222", "HARIHARAN D"},
                {"22Z223", "HARISH K"},
                {"22Z224", "HARSHINI S P"},
                {"22Z225", "HEMANTHKUMAR V"},
                {"22Z226", "INIYAA N"},
                {"22Z227", "JAYAVARSHINI S S"},
                {"22Z228", "JEEVASHAKTHI V"},
                {"22Z229", "KABHINYASRI S V"},
                {"22Z231", "KARTHIK SRINIVAS S"},
                {"22Z232", "KISHOREADHITH V"},
                {"22Z233", "M RAJ RAGAVENDER"},
                {"22Z234", "MADDI SRINIVASA PADMAVATHI"},
                {"22Z235", "MADHISHA S"},
                {"22Z236", "MANOJKUMAR K"},
                {"22Z237", "MANORANJAN A"},
                {"22Z238", "MITHRA K M"},
                {"22Z239", "MOHAMED MUZAMMIL J"},
                {"22Z240", "MONISH RAJAN L"},
                {"22Z241", "MOUMITHA K"},
                {"22Z242", "NAVEEN RAGAV K"},
                {"22Z243", "O KEERTHI"},
                {"22Z244", "PRAMODINI P"},
                {"22Z245", "PRANAVJI K"},
                {"22Z246", "PRATEEKSHAA T"},
                {"22Z247", "PRATISH MITHRA J"},
                {"22Z248", "PREAM S"},
                {"22Z249", "PRITHVIN K C"},
                {"22Z250", "RAJAILAKKIYAN I B"},
                {"22Z251", "RAMAPRIYA S"},
                {"22Z252", "RITHANIYAA B"},
                {"22Z253", "RITHVIK K"},
                {"22Z254", "ROHITH PRAKASH"},
                {"22Z255", "S AKASH"},
                {"22Z256", "S KARTHIKEYAN"},
                {"22Z257", "SANDEEP K"},
                {"22Z258", "SANDHIYA R"},
                {"22Z259", "SANJITHA R"},
                {"22Z260", "SNESHA B"},
                {"22Z261", "SREERAGHAVAN R"},
                {"22Z262", "SRI DEV S"},
                {"22Z263", "SRIHARI K K"},
                {"22Z264", "SRUTHI S"},
                {"22Z265", "SUDHANBALAJI M"},
                {"22Z266", "THAKSHIN KUMAR T"},
                {"22Z267", "THAMINA ANZUM A"},
                {"22Z268", "THARIGALAKSHMI S"},
                {"22Z269", "THEETCHANAA RA"},
                {"22Z270", "VARSHINI R"},
                {"22Z271", "VIGNESHWARAN P"},
                {"22Z272", "VIJEYASRI T"},
                {"22Z273", "VINITHAA P"},
                {"22Z274", "VISHNU BARATH K"},
                {"22Z275", "VIVEKANAND M U"},
                {"22Z276", "YOHITH MUKILAN N"},
                {"22Z277", "KRISHANU DEY"},
                {"22Z278", "MUKESH E"},
                {"22Z279", "PRANEETH M"},
                {"22Z280", "SIBI SENTHIL"},
                {"23Z431", "DWARKESH"},
                {"23Z432", "KAPIL ARIF K"},
                {"23Z433", "NAVEEN P"},
                {"23Z434", "PRAVEEN G"},
                {"23Z435", "SUDHARSAN S"},
                {"23Z436", "VASANTH KUMAR S B"},
                {"23Z437", "VENKAT RAM"},
                {"23Z438", "DHARSHINI V"},
                {"22Z433", "SANTHOSH T K"}
        };
    }

    public String checkRollNoExist(String rollNo) throws Exception{
        /*
        * Check if the roll no exist. If exist return the name of the student.
        * Otherwise, raise an rollNoNotExist exception.
        * */
        for(String[] students: this.studentData){
            if(Objects.equals(students[0], rollNo)){
                return students[1];
            }
        }

        throw new RollNoNotExistException("Roll no doesn't exist");
    }
}

public class StudentData{

}
