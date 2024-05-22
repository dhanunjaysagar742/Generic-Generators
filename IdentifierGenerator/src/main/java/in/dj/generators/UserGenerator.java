package in.dj.generators;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserGenerator implements IdentifierGenerator{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String STRING_FORMAT="USER-";
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		int NUMBER_FORMAT=0;
		String maxNumberFromDB="";		
		String maxIdFromDB = (String) session.createQuery("select max(e.id) from User e").uniqueResult();
		
		 if (maxIdFromDB == null) {
			 NUMBER_FORMAT = 0001; // Set initial value if the table is empty
		    } else {
		    	maxNumberFromDB=maxIdFromDB.split("-")[2];
		    	 NUMBER_FORMAT=Integer.parseInt(maxNumberFromDB);
		    	 NUMBER_FORMAT++;
		    }
		
		
		    String DATE_FORMAT = new SimpleDateFormat("yyyyMMdd").format(new Date());
		    String FINAL_FORMAT = STRING_FORMAT + DATE_FORMAT + "-" + String.format("%04d", NUMBER_FORMAT);
		    
		    return FINAL_FORMAT;
	}

	
}
