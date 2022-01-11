package solver;
import java.util.*;
import java.lang.*;
import java.io.*;
import game.*;

/**
 * Contrainte portant sur la différence
 */
public class PetitConstraint implements Constraint{

    private CaseBlanche v1;
    private int valeur;
    public PetitConstraint(CaseBlanche v1,int valeur)
    {
        this.v1=v1;
        this.valeur=valeur;
    }

    public CaseBlanche getV1()
    {
        return this.v1;

    }
    public int getValeur()
    {
        return this.valeur;

    }

    @Override
    //Retourne les CaseBlanche affectées par la contrainte
    public Set<CaseBlanche>getScope()
    {
        Set<CaseBlanche> setCaseBlanche = new HashSet<>(); 
        setCaseBlanche.add(v1);
        return setCaseBlanche;
    }

    @Override
    //Verifie que la contraite est satisfaite par la map en parametre 
    public boolean isSatisfiedBy(Map<CaseBlanche,Integer>verifMap)
    {
        //Test si les variables sont contenu dans la map
        if(verifMap.containsKey(v1))
        {
            // La valeur de case blanche doit etre plus petit ou egale à la valeur de la contrainte
            return (verifMap.get(v1)<=valeur);
            
        }
       throw new IllegalArgumentException("La case blanches n'est pas inclus dans la map");
    
    }
}