package it.its.wordscounter.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String[] words = value.toString().replaceAll("&.*?\\w+;", " ")               
                .replaceAll("[^a-zA-Z0-9 ]", " ")         
                .replaceAll("\\s+", " ").split(" ");
		
		IntWritable valueOutInt = new IntWritable(1);
		
		
		for(String word : words) {
			Text keyOutText = new Text(word);
			output.collect(keyOutText, valueOutInt);
		}
           
	}

}
