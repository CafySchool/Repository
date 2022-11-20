package it.its.marryscount.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String[] row = value.toString().split(";");
		String KeyOut = row[1]+row[2];
		Text keyOutText = new Text(KeyOut);
		IntWritable valueOutInt = new IntWritable(1);
		output.collect(keyOutText, valueOutInt);
		
	}

}
