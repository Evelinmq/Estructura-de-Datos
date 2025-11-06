public class JobCustom {

    String id;

    public JobCustom(String id) {
        this.id = id;
    }

    public JobCustom() {
    }

    @Override
    public String toString() {
        return "JobCustom [id=" + id + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
