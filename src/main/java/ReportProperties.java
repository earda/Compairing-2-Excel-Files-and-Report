import java.util.Date;

public class ReportProperties {
    String name;
    String surname;
    String date;
    String birthL;
    String mail;
    String phone;
    String status;
    String jobStatus;
    String universty;
    String wrong;

    public ReportProperties(String name, String surname, String date, String birthL, String mail, String phone, String status, String jobStatus, String universty,String wrong) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.birthL = birthL;
        this.mail = mail;
        this.phone = phone;
        this.status = status;
        this.jobStatus = jobStatus;
        this.universty = universty;
        this.wrong = wrong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBirthL() {
        return birthL;
    }

    public void setBirthL(String birthL) {
        this.birthL = birthL;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getUniversty() {
        return universty;
    }

    public void setUniversty(String universty) {
        this.universty = universty;
    }
    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }


}
