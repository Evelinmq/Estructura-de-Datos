public class Job {
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Job(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return Id;
    }
}
