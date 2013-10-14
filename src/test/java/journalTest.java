import com.cn.thu.journal.Journal;
import com.cn.thu.journal.journalManager;
import com.cn.thu.logic.Mediator;
import com.cn.thu.utility.PageControl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-4
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public class journalTest {
    @Test
    public  void  sortSearchTest() throws SQLException {
        System.out.println(journalManager.searchById("10").getAuthor1());
    }
//    @Test
//    public void simpleSearchTest() throws SQLException {
//       System.out.println(Mediator.simpleSearch("校外活动",1,10,true));
//       System.out.println(journalManager.simpleSearch("校外活动",1,10,true));
//        Vector<Journal> journals = journalManager.simpleSearch("校外活动",1,10,true);
//        System.out.println(journals.toString());
//    }
//    @Test
//    public  void simpleAllTest() throws SQLException {
//        Vector<Journal> journals = journalManager.simpleAll(1,10);
////        System.out.println(journals.toString());
//    }
//    @Test
//    public  void  getTotalRows() throws SQLException {
////        System.out.println(journalManager.getTotalRows());       // select count(*) from journal ,
//          // so         rs = du.executeQuery(SQLCommand);       rs.last(); //移到最后一行
////         int rowCount = rs.getRow(); //得到当前行号，也就是记录数      result: 1
//
//    }
//    @Test
//    public  void getPageControl() {
//        PageControl pageCtl =  new PageControl();
//        pageCtl.setCurPage(1);
//        pageCtl.setMaxRowCount(8);       // maxRows
//        pageCtl.setRowsPerPage(1);
//        pageCtl.countMaxPage();
//        System.out.println(pageCtl.getCurPage()+pageCtl.getMaxPage());
//    }
//    }
//     @Test
//     public  void getDate() {
//     Date date = journalManager.getDateFromString("2012年10月1日");
//         java.sql.Timestamp ts = null;
//         Calendar calendar = GregorianCalendar.getInstance();
//         calendar.setTime(date);
//         if(date != null){
//
//             ts = new java.sql.Timestamp(date.getTime());
//         }
//         System.out.println(date.toString());
//         System.out.println(ts.toString());
//         System.out.println(calendar.get(Calendar.YEAR));
//     }
//    @Test
//    public void complexSearch() throws SQLException {
//        Vector<Journal> journals = journalManager.complexSearch("",0,"清华",0," ",0," ",0," ",0," ",0," ");
//        System.out.println(journals.size());
//
//}
}
