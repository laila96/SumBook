package in.ezeon.capp.dao;

import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.rm.ContactRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.omg.CORBA.DomainManager;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;




@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {
	@PersistenceContext
	private DomainManager em;

    @Override
    public void save(Contact c) {
        String sql = "INSERT INTO contact(userId, name, author, category, summary, nomphoto, photo) VALUES(:userId, :name, :author, :category, :summary, :nomphoto, :photo)";
        Map m = new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("author", c.getAuthor());
        m.put("category", c.getCategory());
        m.put("summary", c.getSummary());
        m.put("nomphoto", c.getNomphoto());
        m.put("photo", c.getPhoto());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        c.setContactId(kh.getKey().intValue());
    }

    @Override
    public void update(Contact c) {
        String sql = "UPDATE contact SET name=:name, author=:author, category=:category, summary=:summary, nomphoto=:nomphoto, photo=:photo WHERE contactId=:contactId";
        Map m = new HashMap();
        m.put("contactId", c.getContactId());
        m.put("name", c.getName());
        m.put("author", c.getAuthor());
        m.put("category", c.getCategory());
        m.put("summary", c.getSummary());
        m.put("nomphoto", c.getNomphoto());
        m.put("photo", c.getPhoto());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Contact c) {
        this.delete(c.getContactId());
    }

    @Override
    public void delete(Integer contactId) {
        String sql = "DELETE FROM contact WHERE contactId=?";
        getJdbcTemplate().update(sql, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
        String sql = "SELECT contactId, userId, name, author, category, summary, nomphoto, photo FROM contact WHERE contactId=?";
        return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "SELECT contactId, userId, name, author, category, summary, nomphoto, photo FROM contact";
        return getJdbcTemplate().query(sql, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProperty(String propName, Object propValue) {
        String sql = "SELECT contactId, userId, name, author, category, summary, nomphoto, photo FROM contact WHERE "+propName+"=?";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
    }
    
    @Override
    public Contact getContact(Integer contactId) {
		// TODO Auto-generated method stub
    	return ((EntityManager) em).find(Contact.class, contactId);
	}

}
