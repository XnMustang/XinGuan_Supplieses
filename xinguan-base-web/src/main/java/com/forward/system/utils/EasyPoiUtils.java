package com.forward.system.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.forward.system.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/12/8
 */
public class EasyPoiUtils {

    /**
     * 导出Excel
     * @param pojoClass Excel对象Class
     * @param dateSet   Excel对象数据List
     * @param path      路径
     * @param filename  文件名称
     */
    public static void exportExcel(Class<?> pojoClass, Collection<?> dateSet, String path, String filename) throws IOException {
        File saveFile = new File(path);
        //判断保存文件的路径是否存在
        if(!saveFile.exists()){
            //不存在就新建
            saveFile.mkdirs();
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),pojoClass,dateSet);
        FileOutputStream fos = new FileOutputStream(path + filename);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    /**
     * 根据Map创建对应的Excel(一个Excel,创建多个sheet)
     * @param list  list中多个Map ,key title对应表格Title key, entity对应表格对应实体 key data Collection 数据
     * @param path  路径
     * @param filename  文件名
     */
    public static void exportExcel(List<Map<String,Object>> list, String path, String filename) throws IOException {
        File saveFile = new File(path);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        FileOutputStream fos = new FileOutputStream(path + filename);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    /**
     * Excel导入数据源本地文件,不返回校验结果，导入字段类型 Integer,Long,Double,Date,String,Boolean
     * @param file          文件
     * @param pojoClass     Excel对象Class
     * @param params        导入参数
     * @param <T>
     * @return
     */
    public static <T> List<T> importExcel(File file, Class<?> pojoClass, ImportParams params){
        long start = new Date().getTime();
        List<T> list = ExcelImportUtil.importExcel(file, User.class, params);
        return list;
    }

}
