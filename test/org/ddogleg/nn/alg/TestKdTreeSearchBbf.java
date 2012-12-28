package org.ddogleg.nn.alg;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Peter Abeles
 */
public class TestKdTreeSearchBbf extends StandardKdTreeSearchTests {
	@Override
	public KdTreeSearch createAlg() {
		// specify so many max nodes that it will be optimal
		return new KdTreeSearchBbf(10000);
	}

	/**
	 * Provide an insufficient number of steps to produce an optimal solution and see if it produces the expected
	 * result
	 */
	@Test
	public void checkMaxNodes() {
		KdTree tree = createTreeA();

		KdTreeSearchBbf alg = new KdTreeSearchBbf(0);
		alg.setTree(tree);

		KdTree.Node found = alg.findClosest(new double[]{12,2});

		// The first search from the root node is not counted.  In that search it will traverse down to a leaf
		assertTrue(found==tree.root.left.right);
	}

	/**
	 * Provide multiple trees for input and see if it finds the best one
	 */
	@Test
	public void multiTreeSearch() {
		KdTree forest[] = new KdTree[2];
		forest[0] = createTreeA();
		forest[1] = new KdTree(2);
		forest[1].root = new KdTree.Node(new double[]{12,2},null);

		KdTreeSearchBbf alg = new KdTreeSearchBbf(200);
		alg.setTrees(forest);

		KdTree.Node found = alg.findClosest(new double[]{12,3});

		// make sure it searched some nodes besides the root ones
		assertTrue(alg.numNodesSearched>0);
		// the best node should be the root node in the second forest
		assertTrue(found==forest[1].root);
	}

}