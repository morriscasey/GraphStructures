/**
 * Created by Casey Morris on 2/15/15.
 * Representation of a graph vertex
 */
public class Vertex {
    private final String label;   // label attached to this vertex
    private int iDegree; // indegree of vertex



    /**
     * Construct a new vertex
     *
     * @param label the label attached to this vertex
     */
    public Vertex(String label) {
        if (label == null) {
            throw new IllegalArgumentException("null");
        }

        this.label = label;
        this.iDegree = 0;


    }
    /**
     * Get indegree of vertex
     * @return indegree of vertex
     */
    public int getIndegree(){ return iDegree;}

    /**
     * Get a vertex label
     *
     * @return the label attached to this vertex
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set indegree of vertex
     * @param degree inputs how many vertices adj to vertex
     */
    public void setIndegree(int degree){
        this.iDegree = degree;
    }

    /**
     * A string representation of this object
     *
     * @return the label attached to this vertex
     */
    public String toString() {
        return label;
    }

    //auto-generated: hashes on label
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    //auto-generated: compares labels
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Vertex other = (Vertex) obj;

        if (label == null) {
            if (other.label != null) {
                return false;
            }
        } else if (!label.equals(other.label)) {
            return false;
        }

        return true;
    }


}