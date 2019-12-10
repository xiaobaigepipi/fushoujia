package com.lxh.fushoujia.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.lxh.fushoujia.pojo.Project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/*
 * @PackageName: com.lxh.fushoujia.util
 * @ClassName: PDFUtil
 * @Description:
 * @author: 辉
 * @date: 2019/12/9 22:16
 * */
public class PDFUtil {

    public void generatePDF(Project project) {

        //新建Document对象
        Document document = new Document();

        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\testFile\\" + project.getName() +".pdf"));

            //打开文档
            document.open();

            //添加一个内容段落
            //document.add(new Paragraph("hello world1231233211111111111"));

            //标题
            document.addTitle("测试pdf");
            //
            document.addAuthor("作者");

            //主题
            document.addSubject("this is subject");
            //关键字
            document.addKeywords("Keywords");
            //创建时间
            document.addCreationDate();
            //应用程序
            document.addCreator("hd.com");

            createContent(document, project);

            //关闭文档
            document.close();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }

    public void createContent(Document document, Project project)throws FileNotFoundException, DocumentException, IOException {
        //中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        //标题字体
        Font titlefont = new Font(bfChinese);
        titlefont.setColor(BaseColor.BLACK);
        titlefont.setSize(17);
        titlefont.setStyle(Font.BOLD);
        //正文字体
        Font textfont = new Font(bfChinese, 12);
        textfont.setColor(BaseColor.BLACK);

        //创建标题
        Paragraph p = new Paragraph(project.getName() + " " + "项目基本信息", titlefont);
        //居中
        p.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        p.setIndentationLeft(12); //设置左缩进
        p.setIndentationRight(12); //设置右缩进
        //p.setFirstLineIndent(24); //设置首行缩进
        p.setLeading(20f); //行间距
        p.setSpacingBefore(5f); //设置段落上空白
        p.setSpacingAfter(10f); //设置段落下空白

        document.add(p);

        //创建表格和内容
        // 添加表格，4列
        PdfPTable table = new PdfPTable(2);
        //// 设置表格宽度比例为%100
        table.setWidthPercentage(100);
        // 设置表格的宽度
        table.setTotalWidth(500);
        // 也可以每列分别设置宽度
        table.setTotalWidth(new float[] { 150, 350});
        // 锁住宽度
        table.setLockedWidth(true);
        // 设置表格上面空白宽度
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
        table.setSpacingAfter(10f);
        // 设置表格默认边框为1
        table.getDefaultCell().setBorder(1);
        //PdfContentByte cb = writer.getDirectContent();

        table.addCell(createCellLeft("项目名称", textfont));
        table.addCell(createCellRight(project.getName(), textfont));

        table.addCell(createCellLeft("项目负责人", textfont));
        table.addCell(createCellRight(project.getPrincipal(), textfont));

        table.addCell(createCellLeft("项目编号", textfont));
        table.addCell(createCellRight(project.getCode(), textfont));

        table.addCell(createCellLeft("立项日期", textfont));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        table.addCell(createCellRight(sf.format(project.getProjectDate()), textfont));

        table.addCell(createCellLeft("甲方单位名称", textfont));
        table.addCell(createCellRight(project.getClient(), textfont));

        table.addCell(createCellLeft("项目类型", textfont));
        table.addCell(createCellRight(project.getType(), textfont));

        table.addCell(createCellLeft("项目属性", textfont));
        table.addCell(createCellRight(project.getProperty(), textfont));

        table.addCell(createCellLeft("项目来源", textfont));
        table.addCell(createCellRight(project.getOrigin(), textfont));

        table.addCell(createCellLeft("省份", textfont));
        table.addCell(createCellRight(project.getProvince(), textfont));

        table.addCell(createCellLeft("城市", textfont));
        table.addCell(createCellRight(project.getCity(), textfont));

        table.addCell(createCellLeft("项目实施地点", textfont));
        table.addCell(createCellRight(project.getWorkPlace(), textfont));

        table.addCell(createCellLeft("总建筑面积（平方米）", textfont));
        table.addCell(createCellRight(project.getBuildArea().toString(), textfont));

        table.addCell(createCellLeft("总用地面积（平方米）", textfont));
        table.addCell(createCellRight(project.getLandArea().toString(), textfont));

        table.addCell(createCellLeft("预计合同标的", textfont));
        table.addCell(createCellRight(project.getSubject().toString(), textfont));

        table.addCell(createCellLeft("招投标类型", textfont));
        table.addCell(createCellRight(project.getTenderType(), textfont));

        if (project.getTenderType().equals("代理")) {
            table.addCell(createCellLeft("代理供应商", textfont));
            table.addCell(createCellRight(project.getSupplier(), textfont));
        }

        table.addCell(createCellLeft("项目实施所", textfont));
        table.addCell(createCellRight(project.getDepartments(), textfont));

        table.addCell(createCellLeft("项目描述", textfont));
        table.addCell(createCellRight(project.getDescription(), textfont));

        table.addCell(createCellLeft("项目开始日期", textfont));
        table.addCell(createCellRight(sf.format(project.getStartDate()), textfont));

        table.addCell(createCellLeft("项目结束日期", textfont));
        table.addCell(createCellRight(sf.format(project.getEndDate()), textfont));

        document.add(table);

    }

    public PdfPCell createCellLeft(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(content, font));
        //设置背景颜色
        cell.setBackgroundColor(new BaseColor(245, 245, 245));
        //设置垂直居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //设置向右对齐
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        //设置内边边距
        cell.setPadding(10f);
        return cell;
    }

    public PdfPCell createCellRight(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(content, font));
        //设置垂直居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //设置向左对齐
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        //设置内边边距
        cell.setPadding(10f);
        return cell;
    }

}
