package executer_Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Class_ScheduledThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ExecutorService service=Executors.newScheduledThreadPool(5);//5,Max_VALUE,0L,DelayedWorkedQueue;
		Service1 s1=new Service1();
		Service1 s2=new Service1();
		Service1 s3=new Service1();
		Service1 s4=new Service1();
		
		service.submit(s1);
		service.submit(s2);
		service.submit(s3);
		service.submit(s4);
		
		System.out.println(" Main method Before :"+service.isTerminated());
		
		service.shutdown();
		
		while(service.isTerminated())
		{
			
		}
		System.out.println("Main Method Terminated :"+service.isTerminated());
		System.out.println(" Main Method Completed...");
		
		

	}

}
class Exam6 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++){
		System.out.println(Thread.currentThread().getName()+" is performing:"+1);
		}
	}
	
}