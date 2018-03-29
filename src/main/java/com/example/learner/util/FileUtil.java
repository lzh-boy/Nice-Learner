package com.example.learner.util;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/5
 * Time : 14:02
 * Talk is cheap. Show me the code.
 */
public class FileUtil {

    public final static Logger logger= LoggerFactory.getLogger(FileUtil.class);
    public final static String directory="C:\\Users\\DELL\\IdeaProjects\\mavenSpringMVC\\target\\mavenSpringMVC\\WEB-INF\\statics\\blog\\";
    public final static String getDirectoryIdea="http://localhost:8080/mavenSpringMVC/blog/";
    public final static String directoryIdea="C:\\Users\\DELL\\IdeaProjects\\learner\\src\\main\\resources\\video";
    @Test
    public void TestSaveBlog() throws IOException {
       newFile(directoryIdea,"2111","test the save blog");
       // newFolder("test");
        //delFile(directory+"test.txt");
        //delFolder(directory);
        //deleteFile("03ea9afbe59d4d11b6522b9e439e60f1.txt");
        //readTxt("C:\\Users\\DELL\\IdeaProjects\\mavenSpringMVC\\target\\mavenSpringMVC\\WEB-INF\\statics\\blog\\93214a7fce9940dca6898e69d64003c8.txt");
    }

    public static String readTxt(String path) throws IOException {

            String encoding = "GBK";
            File file = new File(path);
            String lineTxt = null;
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                }
                read.close();
            }
        return lineTxt;
    }
    /**
     * 新建目录
     */
    public static void newFolder(String folderPath) {
            String filePath = directory+folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if(!myFilePath.exists()) {
                myFilePath.mkdir();
            }
            System.out.println("新建目录操作 成功执行");
    }

    public  static  void newFile(String Directory, String FileName,String FileText) throws IOException {
        //注释掉的为方法一
    /*File file=new File(directory,filename);
    if (file.exists()) {
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
    }else {
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

        File file=new File(Directory,FileName+".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
            //向指定文件中写入文字
            FileWriter fileWriter;
            fileWriter = new FileWriter(FileName+".txt");
            //使用缓冲区比不使用缓冲区效果更好，因为每趟磁盘操作都比内存操作要花费更多时间。
            //通过BufferedWriter和FileWriter的连接，BufferedWriter可以暂存一堆数据，然后到满时再实际写入磁盘
            //这样就可以减少对磁盘操作的次数。如果想要强制把缓冲区立即写入,只要调用writer.flush();这个方法就可以要求缓冲区马上把内容写下去
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(FileText);
            bufferedWriter.close();
            System.out.println("保存成功 成功执行");
    }

    /**
     * 上传单个文件
     * @param file
     * @param Directory
     * @return
     */
    public static boolean upload( MultipartFile file,String Directory){
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File(Directory+saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                logger.info("上传成功");
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                logger.error("上传失败",e.getMessage());
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("上传失败",e.getMessage());
                return false;
            }
        } else {
            logger.error("上传失败,文件为空");
            return false;
        }
    }

    /**
     * 上传多个文件
     * @return
     * @throws IOException
     */
    public String uploadFiles(HttpServletRequest request, String Directory) throws IOException {
        File savePath = new File(Directory);
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File saveFile = new File(savePath, file.getOriginalFilename());
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    if (stream != null) {
                        stream.close();
                        stream = null;
                    }
                    return "第 " + i + " 个文件上传有错误" + e.getMessage();
                }
            } else {
                return "第 " + i + " 个文件为空";
            }
        }
        return "所有文件上传成功";
    }
    /**
     * 删除文件
     */
    public  static void deleteFile(String fileName) {
            String filePath = directory+fileName;
            filePath = filePath.toString();
            File myDelFile = new File(filePath);
            myDelFile.delete();
            System.out.println("删除文件操作 成功执行");
    }
    /**
     * 删除文件夹
     */
    public void delFolder(String folderPath) {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if(myFilePath.delete()) { //删除空文件夹
                System.out.println("删除文件夹" + folderPath + "操作 成功执行");
            } else {
                System.out.println("删除文件夹" + folderPath + "操作 执行失败");
            }
    }
    /**
     * 删除文件夹里面的所有文件
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if(!file.exists()){
            return;
        }
        if(!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++){
            if(path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }

            if (temp.isDirectory()) {
                //delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件
                deleteFile(path+ File.separatorChar + tempList[i]);//再删除空文件夹
            }
        }
        System.out.println("删除文件操作 成功执行");
    }


}
