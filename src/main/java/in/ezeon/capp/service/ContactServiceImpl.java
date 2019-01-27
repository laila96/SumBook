package in.ezeon.capp.service;

import in.ezeon.capp.dao.BaseDAO;
import in.ezeon.capp.dao.ContactDAO;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.rm.ContactRowMapper;
import in.ezeon.capp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
    
    @Autowired
    private ContactDAO contactDAO;
    
    @Override    
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer cotactId) {
        contactDAO.delete(cotactId);
    }

    @Override
    public void delete(Integer[] cotactIds) {
        String ids = StringUtil.toCommaSeparatedString(cotactIds);
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, author, category , summary, nomphoto, photo FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%'  OR author LIKE '%"+txt+"%' OR category LIKE '%"+txt+"%' OR summary LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
    }

    @Override
    public Contact findById(Integer cotactId) {
        return contactDAO.findById(cotactId);
    }
    
    @Override
    public List<Contact> findContact() {
        String sql = "SELECT contactId, userId, name, author, category , summary, nomphoto, photo FROM contact";
        return getJdbcTemplate().query(sql, new ContactRowMapper()); 
    }
    
}
