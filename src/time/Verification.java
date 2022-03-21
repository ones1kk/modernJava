package time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Verification {

    private final String code;

    private final Duration duration;

    private final LocalDateTime createdDateTime = LocalDateTime.now();

    public Verification(String code) {
        this.code = code;
        this.duration = Duration.ofMillis(1000L);
    }

    public Verification(String code, Duration duration) {
        if (code.length() > 6) {
            throw new RuntimeException();
        }
        if (duration.getSeconds() > 180) {
            throw new RuntimeException();
        }
        if (code.isBlank() || code.isEmpty()) {
            throw new RuntimeException();
        }

        this.code = code;
        this.duration = duration;
    }

    public static void main(String[] args) throws InterruptedException {
        String code = "123456";

        Verification verification = new Verification(code, Duration.ofMillis(1000L));
        System.out.println(verification.verify("123456"));

        Thread.sleep(2000L);
        System.out.println(verification.verify("123123"));

//        Verification exception = new Verification("", Duration.ofMillis(100));

        /********************************V2********************************/
        System.out.println();
        String code1 = "aaaaaa";
        Verification verification1 = new Verification(code1);

        System.out.println(verification1.verify("123456"));
        System.out.println(verification1.verify("aaaaaa"));

        Thread.sleep(3000L);
        System.out.println(verification1.verify("aaaaaa"));


    }

    public boolean verify(String code) {
        if (!Objects.equals(this.code, code)) {
            return false;
        }

        return !isExpired();
    }

    public boolean isExpired() {
        Duration duration = Duration.between(this.createdDateTime, LocalDateTime.now());
        return duration.isNegative() || duration.getSeconds() > this.duration.getSeconds();
    }

    public String getCode() {
        return code;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
}
