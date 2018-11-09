package spittr;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spitter {
	private Long id;
	
	@NotNull
	@Size(min=5,max=16)
	private String userName;
	
	@NotNull
	@Size(min=5,max=25)
	private String passWord;
	
	@NotNull
	@Size(min=2,max=30)
	private String firstName;
	
	@NotNull
	@Size(min=2,max=30)
	private String lastName;

	public Spitter() {}

	public Spitter(Long id, String userName, String passWord, String firstName,
			String lastName) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Spitter(String userName, String passWord, String firstName,
			String lastName) {
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	
}
