//Customised Database Management System

class node
{
    public Integer Rno;
    public String Name;
    public String City;
    public Integer Marks;
    node next;

    public node(int A , String B , String C , int D)
    {
        Rno = A;
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node first;
    private int Count;

    public DBMS()
    {
        first = null;
        Count = 0;
        System.out.println("DBMS initialized successfully...");
        System.out.println("Student Table gets created successfully");

        
    }

    //Insert Last
    //Isert into table student values(1,"amit","pune",89)
    public void InsertIntoTable(int Rno , String Name , String City , int Marks)
    {
        node newn = new node(Rno,Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newn;

        System.out.println("One record gets inserted successfullly");
        Count++;
        }
    }

    //select * from student
    public void SelectStarFrom()
    {
        node temp = first;
        System.out.println();
        System.out.println("----------------------------------------------------------");
        while(temp != null)
        {
           
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks+"\t");
            temp = temp.next;
            
        }
        System.out.println("-----------------------------------------------------------");
    }
    public int count()
    {
        return Count;
    }
    //Describe table
    public void Describe()
    {

        System.out.println("-------------------------------------------------------------");
        System.out.println("Column Name \t datatype");
        System.out.println("Rno"+"\t\t"+first.Rno.getClass().getSimpleName());
        System.out.println("Name"+"\t\t"+first.Name.getClass().getSimpleName());
        System.out.println("City"+"\t\t"+first.City.getClass().getSimpleName());
        System.out.println("Marks"+"\t\t"+first.Marks.getClass().getSimpleName());
        System.out.println("--------------------------------------------------------------");
    }
    //select min(marks)from student
    public int MinMarks()
    {
        node temp = first;
        int imin = temp.Marks;

        while(temp != null)
        {
            if(temp.Marks < imin)
            {
                 imin = temp.Marks;
            }
             temp = temp.next;
        }
        return imin;
    }

    public int MaxMarks()
    {
        node temp = first;

        int iMax = temp.Marks;

        while(temp != null)
        {
            if(temp.Marks > iMax)
            {
                iMax = temp.Marks;
            }
            temp = temp.next;
        }
        return iMax;
    }
    //select (avg)marks 
    public int AvgMarks()
    {
        node temp = first;

        int icnt = 0;
        int iSum = 0;
        int iAvg = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            icnt++;
            temp = temp.next;
        }
        iAvg = iSum / icnt;

        return iAvg;

    }
    //select count(rno)
    public int CountRollNo()
    {
        int icnt = 0;
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno != null)
            {
                icnt++;
            }
            temp = temp.next;
        }
        return icnt;
    }
    //select name , marks from where marks between _ & _
    public void MarksBetween(int iNo1 , int iNo2)
    {
        node temp = first;
        System.out.println("----------------------------------------------------------");
        System.out.println("Record Between the range\t"+iNo1+"and\t"+iNo2+"\tis:");
        System.out.println("Name\tMarks");
        while(temp != null)
        {
            if(temp.Marks >= iNo1 && temp.Marks <= iNo2)
            {
              //  System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks+"\t");
              
              System.out.println(temp.Name+"\t"+temp.Marks+"\t");
            }
            temp = temp.next;
        }
         System.out.println("----------------------------------------------------------");
    }

    //select name , rollno where city between('mumbai','pune')
    public void In(String str1 , String str2)
    {
        node temp = first;
        System.out.println("----------------------------------------------------------");
        System.out.println("Records From\t" +str1+ "\tand\t" +str2+ "\tare :");
         System.out.println("Rno\tName");
        while(temp != null)
        {
            if((temp.City == "Pune")||(temp.City == "Mumbai"))
            {
               
                System.out.println(temp.Rno+"\t"+temp.Name+"\t");   
            }
            temp = temp.next;
        }
        System.out.println("----------------------------------------------------------");


    }
    //where caluse(select * from student where marks >90)
    public void WhereMarks()
    {
        node temp = first;

         System.out.println("----------------------------------------------------------");
         System.out.println("Records of marks greater than 90");
        while(temp!=null)
        {
            if(temp.Marks > 90)
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks+"\t");
            }
            temp = temp.next;
        }
         System.out.println("----------------------------------------------------------");
    }
    //select * query using where clause for name
    public void WhereName(String Sname)
    {
            node temp = first;
            System.out.println("----------------------------------------------------------");
            System.out.println("Records Matching with name\t"+Sname+"\tare :");
            while(temp != null)
            {
                if(temp.Name == Sname)
                {
                    System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks+"\t");
                }
                temp = temp.next;
            }
             System.out.println("----------------------------------------------------------");
    }
    //select specific column using select query
    public void SelectSpecific()    //name
    {
        node temp = first;
        System.out.println("----------------------------------------------------------");
        while(temp!= null)
        {
            System.out.println(temp.Name+"\t");
            temp = temp.next;
        }
        System.out.println("----------------------------------------------------------");
    }
    //delete specific record
    public void DeleteSpecficRecord(int ipos)
    {
        node temp = first;
      //  System.out.println("----------------------------------------------------------");
        if(first == null)
        {
            System.out.println("There Are no Records");
        }
        else if(first.next == null)
        {
            first = null;
        }
        else if(ipos == 1)
        {
            first = first.next;
            
        } 
        else if(ipos == Count)
        {
        }
        else
        {
            int i = 0;
            for(i = 1 ; i < ipos-1 ; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        SelectStarFrom();
        System.out.println("1 Record Deleted Successfully");
        //System.out.println("----------------------------------------------------------");
    }
}


class DatabaseCreation
{
    public static void main(String arg[])
    {
        DBMS obj = new DBMS();
        int iRet = 0;

        obj.InsertIntoTable(1,"Amit","Pune",89);
        obj.InsertIntoTable(2,"Pooja","Mumbai",95);
        obj.InsertIntoTable(3,"Rahul","Satara",80);
        obj.InsertIntoTable(4,"Neha","Pune",78);
        obj.InsertIntoTable(5,"Neha","Mumbai",91);

        obj.SelectStarFrom();

        obj.Describe();

        iRet = obj.MinMarks();
        System.out.println("----------------------------------------------------------");
        System.out.println("Minimum Marks  :"+iRet);
        System.out.println("----------------------------------------------------------");


        iRet = obj.MaxMarks();
        System.out.println("----------------------------------------------------------");
        System.out.println("Minimum Marks  :"+iRet);
        System.out.println("-----------------------------------------------------------");

        iRet = obj.AvgMarks();
        System.out.println("----------------------------------------------------------");
        System.out.println("Average of marks  :"+iRet);
        System.out.println("-----------------------------------------------------------");

        iRet = obj.CountRollNo();
        System.out.println("----------------------------------------------------------");
        System.out.println("Total Count of RollNo :"+iRet);
        System.out.println("-----------------------------------------------------------");

        obj.MarksBetween(80,90);

        obj.In("Pune","Mumbai");

        obj.WhereMarks();

        obj.WhereName("Neha");

        obj.SelectSpecific();

     //   obj.OrderByMarksAsc();

        obj.DeleteSpecficRecord(3);
        

    }
}