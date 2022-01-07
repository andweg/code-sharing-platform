package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Code {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    private String uuid;

    private String code;
    private LocalDateTime date;

    private long time;
    private long views;

    @JsonIgnore
    private LocalDateTime expirationDate;

    @JsonIgnore
    private boolean timeRestricted;

    @JsonIgnore
    private boolean viewsRestricted;

    public Code() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return date.format(formatter);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getTime() {
        if (timeRestricted) {
            return LocalDateTime.now().until(expirationDate, ChronoUnit.SECONDS);
        }
        return 0;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getViews() {
        if (viewsRestricted) {
            return views;
        }
        return 0;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setExpirationDate() {
        this.expirationDate = date.plusSeconds(time);
    }

    public boolean isTimeRestricted() {
        return timeRestricted;
    }

    public void setTimeRestricted(boolean timeRestricted) {
        this.timeRestricted = timeRestricted;
    }

    public boolean isViewsRestricted() {
        return viewsRestricted;
    }

    public void setViewsRestricted(boolean viewsRestricted) {
        this.viewsRestricted = viewsRestricted;
    }

    public void setRestrictions() {
        this.timeRestricted = time > 0;
        this.viewsRestricted = views > 0;
    }

    @JsonIgnore
    public boolean isAccessible() {
        if (timeRestricted && getTime() < 0) {
            return false;
        }
        if (viewsRestricted && getViews() <= 0) {
            return false;
        }
        return true;
    }

}