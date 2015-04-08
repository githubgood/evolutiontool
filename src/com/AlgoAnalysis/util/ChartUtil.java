package com.AlgoAnalysis.util;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.*;
public class ChartUtil {
	public static final Font f2=new Font("����",Font.BOLD,10);
	public static final Font f=new Font("����",Font.BOLD,15);
	private Config cf=null;

	/*
	public static ArrayList<ArrayList<Double>> data=new ArrayList<ArrayList<Double>>();*/
	public static double data[][];
	public static String[] alname;
	public static DecimalFormat df=new DecimalFormat("0.000");
	public static int kedu;
	public static int maxcycle;
	public static int showtype;
	
	
	public static CategoryDataset creatDataset(){

		/*//�����ݼ��м���6Ԫ��
		if(data.size() != 0){
			data.clear();
		}
		for(int i=0; i<alname.length; i++){
			
			data.get(i).add(Double.parseDouble(opdata));	
		}
		*/
		
		String[] line=new String[alname.length];
		for(int i=0; i<alname.length; i++){
			line[i]=alname[i]+" ����ֵ��"+data[i][maxcycle-1]+",�ݻ�������"+maxcycle;
		}
		int cl = maxcycle % kedu == 0?maxcycle/kedu:maxcycle/kedu + 1;
		
		String[] category=new String[cl];
		category[0]=String.valueOf(kedu);
		
		for(int i=1; i<category.length; i++){
			category[i]=String.valueOf(Integer.parseInt(category[i-1])+kedu);
		}
		
		DefaultCategoryDataset cdset=new DefaultCategoryDataset();

 		for(int i=0; i<line.length; i++){
			for(int j=0; j<category.length; j++){
				cdset.addValue(data[i][Integer.parseInt(category[j])-1], line[i], category[j]);
			}
		}
		return cdset;
	} 
	
	public static JFreeChart createChart(boolean is3D,String _alname[],int _kedu,int _maxcycle,double value[][],int _showtype){
		JFreeChart chart =null;
		alname = _alname;
		kedu = _kedu;
		maxcycle = _maxcycle;
		data = value;
		showtype = _showtype;
		String tit ="";
		String xtit = "";
		String ytit ="";
		switch(showtype){
		case 0:
			tit = "Best Value/Cycle";
			xtit = "Cycle";
			ytit = "Value";
			break;
		case 1:
			tit = "Fitness/Cycle";
			xtit = "Cycle";
			ytit = "Fitness";
			break;
		case 2:
			tit = "AvgFitness/Cycle";
			xtit = "Cycle";
			ytit = "AvgFitness";
			break;	
		}
		
		
		if(is3D){
			chart =ChartFactory.createLineChart3D(tit,//���� 
					xtit,    //X�����
					ytit,   // y�����
					creatDataset(), 
					PlotOrientation.VERTICAL,
					true, true, false);
		}else {
			chart =ChartFactory.createLineChart(tit,//���� 
					xtit,    //X�����
					ytit,    // y�����
					creatDataset(), 
					PlotOrientation.VERTICAL,
					true, true, false);
		}
		
		chart.getTitle().setFont(new Font("����",Font.BOLD,25));
		
		chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));
		
		chart.setBackgroundPaint(Color.white);
		
		//��û�ͼ������
		CategoryPlot cp=chart.getCategoryPlot();
		
		cp.setBackgroundPaint(Color.white);
		
		//���ú��������
		cp.getDomainAxis().setLabelFont(f);
		
		//������������ֵ����
		cp.getDomainAxis().setTickLabelFont(f2);
	
		//����������������
		cp.getRangeAxis().setLabelFont(f);
		
		//������������������
		cp.getRangeAxis().setTickLabelFont(f);
		
		//����ˮƽ����ı�������ɫ
		cp.setRangeGridlinePaint(Color.red);
		
		cp.setRangeGridlinesVisible(true);
		//����͸����
		cp.setForegroundAlpha(0.4F);
		
		cp.setDomainGridlinePaint(Color.red);
		cp.setDomainGridlinesVisible(true);
		
		//��ȡ���߶���
		LineAndShapeRenderer render=(LineAndShapeRenderer)cp.getRenderer();
		
		BasicStroke realline=new BasicStroke(1.6f);
		
		float[] dash={8.0f};
		
		BasicStroke bokenline =new BasicStroke(1.6f,
				BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_ROUND,
				8.0f,
				dash,
				0.0f
				);
		

		render.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ� 
		render.setBaseLinesVisible(true); // series �㣨�����ݵ㣩������
		
		render.setSeriesStroke(0, bokenline);
		render.setSeriesStroke(1, bokenline);
		render.setSeriesPaint(1, Color.yellow);
		render.setSeriesLinesVisible(1, true);
		
		render.setSeriesStroke(2, realline);
		return chart;
	}
}
