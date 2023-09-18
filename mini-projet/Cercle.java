import java.awt.Color;


public class Cercle implements Mesurable2D {

// Attributs.

	/** Centre du cercle. */
	private Point centre;

	/** Rayon du cercle. */
	private double rayon;

	/** Couleur du cercle. */
	private Color couleur;

// On n'introduit pas d'attribut diametre pour éviter les redondances (contrainte C11).


/** Définition de la constante PI. */

public static final double PI = Math.PI;    // contrainte C12


// Constructeurs.

    /** Créer un cercle à partir de son centre et de son rayon.
     * @param vcentre centre
     * @param vrayon rayon
     */
    public Cercle(Point vcentre, double vrayon) {
	assert (vcentre != null);
	assert (vrayon > 0);
	this.centre = new Point(vcentre.getX(), vcentre.getY());     // exigence E18
	this.rayon = vrayon;
	this.couleur = Color.blue;
    }



    /** Créer un cercle à partir de deux points diamétralement opposés et de sa couleur.
     * @param p1 point1
     * @param p2 point2
     * @param vcouleur couleur
     */
    public Cercle(Point p1, Point p2, Color vcouleur) {
	assert (p1 != null);
	assert (p2 != null);
	assert (vcouleur != null);
	assert (p2.getX() != p1.getX() || p2.getY() != p1.getY());
	this.rayon = p1.distance(p2) / 2;
	this.centre = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
	this.couleur = vcouleur;
    }


    /** Créer un cercle à partir de deux points diamétralement opposés.
     * @param p1 point1
     * @param p2 point2
     */
    public Cercle(Point p1, Point p2) {
	this(p1, p2, Color.blue);
    }



// On définit la méthode de classe.

    /** Créer un cercle à partir de son centre et d'un point appartenant au cercle.
     * @param vcentre centre
     * @param p point
     * @return cercle
     */
    public static Cercle creerCercle(Point vcentre, Point p) {
	assert (vcentre != null);
	assert (p != null);
	return new Cercle(vcentre, vcentre.distance(p));
    }



// On définit les méthodes.

    /** Translater le cercle.
     * @param dx translation abscisse
     * @param dy translation ordonnée
     */
    public void translater(double dx, double dy) {
        this.centre.translater(dx, dy);    // il suffit de translater le centre du cercle
    }


    /** Obtenir le centre du cercle.
     * @return centre du cercle
     */
    public Point getCentre() {
        return new Point(this.centre.getX(), this.centre.getY());        // exigence E18
    }


    /** Obtenir le rayon du cercle.
     * @return rayon du cercle
     */
    public double getRayon() {
        return this.rayon;
    }


    /** Changer le rayon d'un cercle.
     * @param vrayon rayon du cercle
     */
    public void setRayon(double vrayon) {
	assert (vrayon > 0);
        this.rayon = vrayon;
    }


    /** Obtenir le diamètre d'un cercle.
     * @return diamètre du cercle
     */
    public double getDiametre() {
        return this.rayon * 2;
    }


    /** Changer le diamètre d'un cercle.
     * @param vdiametre diamètre du cercle
     */
    public void setDiametre(double vdiametre) {
	assert (vdiametre > 0);
        setRayon(vdiametre / 2);
    }


    /** Savoir si un point est à l'intérieur d'un cercle (au sens large).
     * @param p point
     * @return booléen
     */
    public boolean contient(Point p) {
	assert (p != null);
	if (p.distance(this.centre) <= this.rayon) {
		return true;
	}
	return false;
    }


    /** Obtenir le périmètre d'un cercle.
     * @return périmètre du cercle
     */
    public double perimetre() {
	return 2 * PI * this.rayon;
    }


    /** Obtenir l'aire d'un cercle.
     * @return aire du cercle
     */
    public double aire() {
	return PI * this.rayon * this.rayon;
    }


    /** Obtenir la couleur d'un cercle.
     * @return couleur du cercle
     */
    public Color getCouleur() {
        return this.couleur;
    }


    /** Changer la couleur d'un cercle.
     * @param vcouleur
     */
    public void setCouleur(Color vcouleur) {
	assert (vcouleur != null);
	this.couleur = vcouleur;
    }



    /** Convertir un cercle en chaine de caractères.
     * @return cercle en chaine de caractères
     */
    public String toString() {
	return "C" + this.rayon + "@" + this.centre;
    }


    /** Afficher un cercle dans le terminal. */
    public void afficher() {
	System.out.println(this);
    }

}
