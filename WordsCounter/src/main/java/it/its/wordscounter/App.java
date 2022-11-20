package it.its.wordscounter;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import it.its.wordscounter.mapper.Map;
import it.its.wordscounter.reducer.Reduce;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	JobConf configuration = new JobConf(App.class);
        configuration.setJobName("Job Counter");
        configuration.setMapperClass(Map.class);
        configuration.setReducerClass(Reduce.class);
        configuration.setCombinerClass(Reduce.class);
        configuration.setInputFormat(TextInputFormat.class);
        configuration.setOutputFormat(TextOutputFormat.class);
        configuration.setOutputKeyClass(Text.class);
        configuration.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(configuration, new Path(args[0]));
        FileOutputFormat.setOutputPath(configuration, new Path(args[1]));
        
        try {
            JobClient.runJob(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
