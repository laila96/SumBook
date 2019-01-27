package in.ezeon.capp.rm;

import in.ezeon.capp.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contact>{
    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact c=new Contact();
        c.setContactId(rs.getInt("contactId"));
        c.setUserId(rs.getInt("userId"));
        c.setName(rs.getString("name"));
        c.setAuthor(rs.getString("author"));       
        c.setCategory(rs.getString("category"));       
        c.setSummary(rs.getString("summary"));
        c.setNomphoto(rs.getString("nomphoto")); 
        c.setPhoto(rs.getBytes("photo")); 
        return c;
    }
    
}
