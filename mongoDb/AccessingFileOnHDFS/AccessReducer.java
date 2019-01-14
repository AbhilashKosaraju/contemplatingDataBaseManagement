package Access;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AccessReducer extends Reducer<Text, IntWritable,Text, IntWritable>{
	private IntWritable total = new IntWritable();
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		for(IntWritable i : values) {
			sum += i.get();
		}
		
		total.set(sum);
		context.write(key, total);
	}
		
}
