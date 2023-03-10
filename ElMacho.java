import greenfoot.*;
import java.util.*;
public class ElMacho extends Player {
    private Stack<TortillaChip> ammo;   
    
    private boolean vPressed;
    private boolean bPressed;
    private boolean rPressed; 
    public ElMacho() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        setImage(img);
        
        vPressed = false;
        bPressed = false;
        rPressed = false;
               
        reload();
        e = new GuacamoleTortillaChip();
        abilities.add(e);
        this.showAmmoCounter();
    }
    
    private void showAmmoCounter() {
            
    }
    
    public void singleFire() {
        getWorld().addObject(ammo.pop(), getX(), getY());
    }
    public void burstFire() {
        int a = 0;
        for(int k = 1; k <= 3; k++) {
            getWorld().addObject(ammo.pop(), getX() + a, getY());
            a += 60;
        } 
    }
    public void reload() {
        ammo = new Stack<TortillaChip>();
        for(int k = 1; k <= 15; k++) {
            ammo.push(new TortillaChip());
        }
    }
    
    public void act() {
        super.act();
        int c = e.getCharge();
        if(c < e.getCooldown()) {
            c--;
            e.setCharge(c);
        }
        if(e.getCharge() == 0) {
            e.setCharge(e.getCooldown());
        }
        if(ammo.size() <= 0) {
            reload();
        } 
        if(ammo.size() >= 3 && Greenfoot.isKeyDown("B") && !bPressed) {
            bPressed = true;
            burstFire();
        }
        if(!Greenfoot.isKeyDown("B") && bPressed) {
            bPressed = false;
        } 
        
        if(Greenfoot.isKeyDown("V") && !vPressed) {
            vPressed = true;
            singleFire();
        }
        if(!Greenfoot.isKeyDown("V") && vPressed) {
            vPressed = false;
        }
        
        if(Greenfoot.isKeyDown("R") && !rPressed){
            rPressed = true;
            reload();
        }
        if(!Greenfoot.isKeyDown("R") && rPressed) {
            rPressed = false;
        }
    }    
    
    public void q() {
        
    }
    public void c() {
        
    }
    public void e() {
        getWorld().addObject(e, this.getX(), this.getY());
    }
    public void x() {
        
    }
}