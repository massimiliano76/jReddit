package com.github.jreddit.comment;

import static com.github.jreddit.utils.restclient.JsonUtils.safeJsonToInteger;
import static com.github.jreddit.utils.restclient.JsonUtils.safeJsonToString;

import org.json.simple.JSONObject;

/**
 * A Reddit comment. Contains the edited timestamp, the body
 *
 * @author Benjamin Jakobus
 * @author Raul Rene Lepsa
 * @author Simon Kassing
 */
public class Comment {


    private String id;
    private String author;
    private String fullname;
    private String parentId;
    private String body;            // The actual body
    private String edited;          // Edited timestamp
    private String created;         // Created UTC timestamp
    private String replies;         // Replies
    private Integer upvotes;        // Number of upvotes that this body received
    private Integer downvotes;      // Number of downvotes that this body received

    public Comment(JSONObject obj) {

        try {
        	
            this.setId(safeJsonToString(obj.get("id")));
            this.setAuthor(safeJsonToString(obj.get("author")));
            this.setFullname(safeJsonToString(obj.get("name")));
            this.setParentId(safeJsonToString(obj.get("parent_id")));
            this.setBody(safeJsonToString(obj.get("body")));
            this.setEdited(safeJsonToString(obj.get("edited")));
            this.setCreated(safeJsonToString(obj.get("created_utc")));
            this.setReplies(safeJsonToString(obj.get("replies")));
            this.setUpvotes(safeJsonToInteger(obj.get("ups")));
            this.setDownvotes(safeJsonToInteger(obj.get("downs")));

        } catch (Exception e) {
            System.err.println("Error mapping JSONObject to Comment");
        }

    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }
    
    @Override
    public String toString() {
    	return "Comment(" + id + ")<" + ((body.length() > 10) ? body.substring(0, 10) : body) + ">";
    }
    
}
