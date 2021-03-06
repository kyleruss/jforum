//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/jforum
//=========================================

package com.kyleruss.jforum.ejb.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="messages", catalog="jforum")
public class Messages  implements java.io.Serializable
{
     private Integer id;
     private Users usersByFromUser;
     private Users usersByToUser;
     private Date sentDate;
     private String subject;
     private String content;

    public Messages() {}
	
    public Messages(Users usersByFromUser, Users usersByToUser, String subject, String content)
    {
        this.usersByFromUser    =   usersByFromUser;
        this.usersByToUser      =   usersByToUser;
        this.subject            =   subject;
        this.content            =   content;
    }
    
    public Messages(Users usersByFromUser, Users usersByToUser, Date sentDate, String subject, String content) 
    {
       this.usersByFromUser     =   usersByFromUser;
       this.usersByToUser       =   usersByToUser;
       this.sentDate            =   sentDate;
       this.subject             =   subject;
       this.content             =   content;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() 
    {
        return this.id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="from_user", nullable=false)
    public Users getUsersByFromUser() 
    {
        return this.usersByFromUser;
    }
    
    public void setUsersByFromUser(Users usersByFromUser)
    {
        this.usersByFromUser = usersByFromUser;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="to_user", nullable=false)
    public Users getUsersByToUser() 
    {
        return this.usersByToUser;
    }
    
    public void setUsersByToUser(Users usersByToUser)
    {
        this.usersByToUser = usersByToUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="sent_date", length=19)
    public Date getSentDate() 
    {
        return this.sentDate;
    }
    
    public void setSentDate(Date sentDate)
    {
        this.sentDate = sentDate;
    }

    
    @Column(name="subject", nullable=false, length=50)
    public String getSubject()
    {
        return this.subject;
    }
    
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    @Column(name="content", nullable=false, length=1500)
    public String getContent()
    {
        return this.content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
}


