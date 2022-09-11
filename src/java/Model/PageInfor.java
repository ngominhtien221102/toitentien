/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class PageInfor {
    private int cp;
    private int nrpp;
    private int size;
    private int np;
    private int begin;
    private int end;
    private int [] arrNrpp = {1,3,5,10,20,50,100,200,500,1000};

    public PageInfor() {
    }

    public PageInfor(int cp, int nrpp, int size, int np, int begin, int end) {
        this.cp = cp;
        this.nrpp = nrpp;
        this.size = size;
        this.np = np;
        this.begin = begin;
        this.end = end;
    }

    public PageInfor(int cp, int nrpp, int size) {
        this.cp = cp;
        this.nrpp = nrpp;
        this.size = size;
    }
    
    public void calc1()
    {
        np =(size + nrpp -1)/nrpp;
        cp = cp<0?0:cp;
        cp = cp>np-1?np-1:cp;
        begin = nrpp * cp;
        end = begin + nrpp -1;
        end = end>size-1?size-1:end;
        pageStart = cp-2;
        pageEnd = cp+2;
        pageStart=pageStart<0?0:pageStart;
        pageEnd= pageEnd>np-1?np-1:pageEnd;
    }
    
    
     public void calc()
    {
        np =(size + arrNrpp[nrpp] -1)/arrNrpp[nrpp];
        cp = cp<0?0:cp;
        cp = cp>arrNrpp[nrpp]-1?arrNrpp[nrpp]-1:cp;
        begin = arrNrpp[nrpp] * cp;
        end = begin + arrNrpp[nrpp] -1;
        end = end>size-1?size-1:end;
        pageStart = cp-2;
        pageEnd = cp+2;
        pageStart=pageStart<0?0:pageStart;
        pageEnd= pageEnd>np-1?np-1:pageEnd;
    }
     
    

    public int getCp() {
        return cp;
    }

    public int getNrpp() {
        return nrpp;
    }

    public int getSize() {
        return size;
    }

    public int getNp() {
        return np;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setNrpp(int nrpp) {
        this.nrpp = nrpp;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNp(int np) {
        this.np = np;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
    private int pageStart;
    private int pageEnd;

    public int getPageStart() {
        return pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public void setArrNrpp(int[] arrNrpp) {
        this.arrNrpp = arrNrpp;
    }

    public int[] getArrNrpp() {
        return arrNrpp;
    }
    
    
    
    
    
}
