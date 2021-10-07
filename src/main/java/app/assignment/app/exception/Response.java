package app.assignment.app.exception;

public class Response {
    private String status;
    private String description;

    public Response() {
    }

    public Response(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
