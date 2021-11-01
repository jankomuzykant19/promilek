package pl.hycom.devops.breathalyser.email;

public interface EmailSender {
    void send(String address, String email);
}
