package model;

public class JobCustom {

   String id;

   public String getId() {
    return id;
   }

   public void setId(String id) {
    this.id = id;
   }

   public JobCustom() {
   }

   public JobCustom(String id) {
    this.id = id;
}

   @Override
   public String toString() {
    return "JobCustom [id=" + id + "]";
   }

}
