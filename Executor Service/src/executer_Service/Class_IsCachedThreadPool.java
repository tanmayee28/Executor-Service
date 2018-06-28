package executer_Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Class_IsCachedThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newCachedThreadPool();//synchronousQueue();(ArrayBLockingQueue with size 1),60L
		Example1 e1=new Example1();
		Example1 e2=new Example1();
		Example1 e3=new Example1();
		
		/*service.submit(e1);
		service.submit(e2);
		service.submit(e3);*/
		

		Example2 e11=new Example2();
		Example2 e22=new Example2();
		Example2 e33=new Example2();
		
		Future<List<Integer>>l1=service.submit(e11);
		System.out.println(l1.get());
		Future<List<Integer>>l2=service.submit(e22);
		System.out.println(l2.get());
		Future<List<Integer>>l3=service.submit(e33);
		System.out.println(l3.get());
		
		service.shutdown();
		
		while(!service.isTerminated())
		{
			//System.out.println(" Currently working not shuted down..");
		}
		//System.out.println(Thread.currentThread().getName()+" Is shutDown"+ service.isShutdown());
		System.out.println(Thread.currentThread().getName()+" is completed");
	}

}
class Example1 implements Runnable{

	@Override
	public void run() {
		List<Integer>li=new ArrayList<>();
		for(int i=1;i<=10;i++)
		{
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			li.add(i);
			System.out.println(Thread.currentThread().getName()+" prints:"+li);
		}
		
	}
	
}
class Example2 implements Callable<List<Integer>>{

	List<Integer> li=new LinkedList<>();
	public List<Integer> call() throws Exception {
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int a=2*i;
			//System.out.println(Thread.currentThread().getName()+" write table-2 :"+a);
			li.add(sum+=i);
		}
		return li;
	}
	
}