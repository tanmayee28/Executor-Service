package executer_Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Class_newFixedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newFixedThreadPool(10);//1,1,0L,LinkedBLockingQueue();
		//in this thread pool it is not necssary if u have created 10 threads means 10 will all perfor
		//some required threads will perform n othreas will wait.
		/*Employee1 e=new Employee1();
		Employee1 e1=new Employee1();
		Employee1 e2=new Employee1();
		
		service.submit(e);
		service.submit(e1);
		service.submit(e2);*/
		
		Employee2 e=new Employee2();
		Employee2 e1=new Employee2();
		Employee2 e2=new Employee2();
		
		Future<Integer>i=service.submit(e);
		System.out.println(" Sum"+i);
		Future<Integer>i1=service.submit(e1);
		System.out.println(" Sum"+i1);
		Future<Integer>i2=service.submit(e2);
		System.out.println(" Sum"+i2);
		//service.submit(e1);
		
		service.shutdown();
		 while(! service.isTerminated())
		 {
		
		}
		System.out.println(Thread.currentThread().getName()+" is shuted Down.Good Byeeeeeeee...:-(");
		System.out.println(" Main Thread is completed..");
	}

}
class Employee1 implements Runnable{
	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<10;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" gives name:"+" Thread - "+i);
		}
	}
	
}
class Employee2 implements Callable<Integer>{

	
	int sum=0;
	public Integer call() throws Exception {
		
		for(int i=100;i>90;i--)
		{
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" gives name "+" Thread - "+i);
			 sum+=i;
		}
	//	System.out.println(Thread.currentThread().getName()+" returns sum "+sum);
		return sum;
	}
	@Override
	public String toString() {
		return "Employee2 [sum=" + sum + "]";
	}
	
}