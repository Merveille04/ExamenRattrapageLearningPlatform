package mooc;

import java.util.*;

public class Platform {
    private Set<Course> listeCours;
    private Set<Person> listeEtudiant;
    private Set<Enrollment> listeInscrits;

	public Platform() {
	}

	/**
	 * Ajoute un cours à la liste de cours dispensés
	 * @param c le cours à ajouter (non null)
	 */
	public void addCourse(Course c) {
            if (c == null){
               throw new IllegalArgumentException ("la course ne peut pas etre nulle");
            }
		listeCours.add(c);
	}

	/**
	 * @return les étudiants inscrits à l'université
	 */
	public Set<Person> students() {
        return listeEtudiant;
	}

	/**
	 * @return les cours dispensés par l'université
	 */
	public Set<Course> courses() {
        return listeCours;
	}

	/**
	 * Inscrire un étudiant à l'université
	 * @param s  l'étudiant à inscrire (non null)
	 */
	public void registerStudent(Person s) {
            if (s == null){
               throw new IllegalArgumentException ("il faut un etudiant");
            }
		listeEtudiant.add(s);
	}

	/**
	 * Inscrire un étudiant à un cours
	 * @param  s l'étudiant
	 * @param  c le cours
	 * @throws PlatformException si l'étudiant n'est pas inscrit à l'université, 
	 * ou si le cours n'est pas dispensé par l'université
	 */
	public void enroll(Person s, Course c) throws PlatformException { 
              if (!listeEtudiant.contains(s) && listeCours.contains(c)){
                  Enrollment inscription = new Enrollment(s, c);
                  listeInscrits.add(inscription);
                 }
              else { 
                 throw new PlatformException ("cet etudiant n'est pas inscrit à l'université", s, c);
              }
        
	}

	/**
	 * Désinscrire un étudiant à un cours
	 * @param  s l'étudiant
	 * @param  c le cours
	 * @throws PlatformException si l'étudiant a déjà une note àce cours
	 */
	public void withdraw(Person s, Course c) throws PlatformException {
            Enrollment inscription = new Enrollment(s, c);
		if (inscription.studentHasMark()== true){
                throw new PlatformException ("cet etudiant a deja une note à ce cours", s, c); }
              else {
                listeEtudiant.remove(s);
                }
	}

	/**
	 * Donner une note à un étudiant pour un cours
	 * @param  s l'étudiant
	 * @param  c le cours
	 * @param  mark la note
	 * @throws PlatformException si l'étudiant n'est pas inscrit à l'université, 
	 * ou si le cours n'est pas dispensé par l'université,
	 * ou si l'étudiant a déjà une note pour ce cours
	 */
	public void setMark(Person s, Course c, int mark) throws PlatformException {
                Enrollment inscription = new Enrollment(s, c);
		if (inscription.studentHasMark()== true){
                throw new PlatformException ("cet etudiant a deja une note à ce cours", s, c); }
                
                if (!listeInscrits.contains(inscription)){
                throw new PlatformException ("cet etudiant n'est pas inscrit", s, c); }
                
                if (!listeCours.contains(c)){
                throw new PlatformException ("ce cours n'est pas dispensé par l'université", s, c); }
                else {
                    inscription.setMark(mark);
                }    
	}

	/**
	 * Connaitre la note d'un étudiant pour un cours
	 * @param  s l'étudiant
	 * @param  c le cours
	 * @return la note de l'étudiant pour le cours
	 * @throws PlatformException si l'étudiant n'est pas inscrit à l'université, 
	 * ou si le cours n'est pas dispensé par l'université
	 * ou si l'étudiant n'a pas encore de note à ce cours
	 */
	public int getMark(Person s, Course c) throws PlatformException {
		Enrollment inscription = new Enrollment(s, c);
                if (!listeInscrits.contains(inscription)){
                throw new PlatformException ("cet etudiant n'est pas inscrit", s, c); }
                
                if (!listeCours.contains(c)){
                throw new PlatformException ("ce cours n'est pas dispensé par l'université", s, c); }
                
                if (inscription.studentHasMark()== false){
                throw new PlatformException ("cet etudiant n'a pas encore de note à ce cours", s, c); }
                else {
                           return inscription.getMark();
                    }
	}

	/**
	 * @param c le cours considéré
	 * @return les étudiants inscrits à ce cours
	 * @throws PlatformException si le cours n'est pas dispensé par l'université
	 */
	public Set<Person> studentsForCourse(Course c) throws PlatformException {
               
		if (!listeCours.contains(c)){
                throw new PlatformException ("ce cours n'est pas dispensé par l'université", s, c); }
                else {
                    return 
                }
	}

	/**
	 * @param s l'étudiant considéré
	 * @return les cours auxquels un étudiant est incrit
	 * @throws PlatformException si l'étudiant n'est pas inscrit à l'université, 
	 */
	public Set<Course> coursesForStudent(Person s) throws PlatformException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * @return les cours auxquels aucun étudiant n'est incrit
	 */
	public Set<Course> emptyCourses() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
