package in.ezeon.capp.domain;

import javax.persistence.Lob;

public class Contact  {
    private Integer contactId; //PK
    private Integer userId;//FK
    private String name;
    private String author;
    private String category;
    private String summary;
    private String nomphoto;
	private byte[] photo;
  
    public Contact() {
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
   public String getNomphoto() {
			return nomphoto;
		}

   public void setNomphoto(String nomphoto) {
			this.nomphoto = nomphoto;
		}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



    
}
