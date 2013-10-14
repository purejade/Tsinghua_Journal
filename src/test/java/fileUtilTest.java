import com.cn.thu.messenger.JSONHelper;
import com.cn.thu.utility.FileUtil;
import  com.cn.thu.utility.Util;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;


/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-15
 * Time: 下午10:35
 * To change this template use File | Settings | File Templates.
 */
public class fileUtilTest {
    @Test
    public void getFileSizeTest(){
        String filePath =  "D:\\pages\\78";
        File file = new File(filePath);
        FileUtil fileUtil = new FileUtil();
        System.out.println(fileUtil.getFileSize(file));
        HashMap<Integer,String> fileNames = fileUtil.getFileNames(file);
        for(int i=0;i<fileNames.size();i++) {
            System.out.println(i + ":" + fileNames.get(i)) ;
        }
    }

//    @Test
//    public  void  isSpaceTest() {
//        if(Util.isContainSpace("12 34")) {
//            System.out.println("ok");
//        }
//
//    }
}
