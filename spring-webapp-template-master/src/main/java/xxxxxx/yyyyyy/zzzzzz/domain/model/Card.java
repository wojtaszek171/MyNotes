package xxxxxx.yyyyyy.zzzzzz.domain.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "CARD")
public class Card implements Serializable {

    /**
     * serial version id.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "CARD_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "CARD_TITLE", nullable = false)
    private String title;

    @Column(name = "CARD_COLOR",  nullable = true, length = 64)
    private String color;

    @Column(name = "CARD_BACKGROUND",  nullable = true, length = 64)
    @Lob
    private Blob background;

    @Column(name = "CARD_X",  nullable = true, length = 64)
    private String x;

    @Column(name = "CARD_Y",  nullable = true, length = 64)
    private String y;

    @Column(name = "ID_BOARD",  nullable = false, length = 64)
    private String id_board;

    @Column(name = "CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Blob getBackground() {
        return background;
    }

    public void setBackground(Blob background) {
        this.background = background;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getId_board() {
        return id_board;
    }

    public void setId_board(String id_board) {
        this.id_board = id_board;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
