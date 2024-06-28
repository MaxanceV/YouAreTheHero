package UnitTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Representation.node.ANode;
import Representation.node.ANodeInner;
import Representation.node.TNodeDecision;
import Representation.node.container.ANodeContainer;

public class NodeContainerTest {
	   private ANodeContainer container;

	    @BeforeEach
	    public void setUp() {
	        container = new ANodeContainer() {
	            @Override
	            public ANodeInner getDefaultStartNode() {
	                // Retourne un nœud par défaut pour les tests
	                return (ANodeInner) getNodesOfTheGame().get("intro.timelin");
	            }
	        };
	    }

	    @Test
	    public void testNodeAdding() {
	        // Ajout d'un nœud de décision
	        TNodeDecision decisionNode = container.addNodeDecision("test.node", "Test Description", "Test Choice Description");
	        assertNotNull("Le nœud ajouté ne doit pas être null", decisionNode);

	        // Vérification que le nœud peut être récupéré correctement
	        ANode retrievedNode = container.getNodeFromId("test.node");
	        assertNotNull("Le nœud récupéré ne doit pas être null", retrievedNode);
	        assertTrue("Le nœud récupéré doit être une instance de TNodeDecision", retrievedNode instanceof TNodeDecision);
	    }

	    @Test
	    public void testNodeExistence() {
	        assertNull("La récupération d'un nœud non existant doit retourner null", container.getNodeFromId("non.existant.node"));
	    }
}
