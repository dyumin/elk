/*******************************************************************************
 * Copyright (c) 2018 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.sequence.graph;

import org.eclipse.elk.alg.layered.graph.LGraph;
import org.eclipse.elk.alg.sequence.options.LabelAlignmentStrategy;
import org.eclipse.elk.alg.sequence.options.LifelineSortingStrategy;
import org.eclipse.elk.alg.sequence.options.SequenceDiagramOptions;
import org.eclipse.elk.graph.ElkNode;

/**
 * A simple data holder class used to pass data about the layout process around to the different phases
 * of the layout algorithm.
 */
public final class LayoutContext {
    // CHECKSTYLEOFF VisibilityModifier
    
    // Layout Graphs
    
    /** The original ELK graph the layout algorithm was called with. */
    public final ElkNode elkgraph;
    /** The {@link SGraph} to be laid out. */
    public SGraph sgraph;
    /** The {@link LGraph} created from the SGraph. */
    public LGraph lgraph;
    
    
    // Layout Settings

    /** The label alignment strategy. */
    public final LabelAlignmentStrategy labelAlignment;
    /** The lifeline sorting strategy. */
    public final LifelineSortingStrategy sortingStrategy;
    /** Whether to include areas in the lifeline sorting process. Used by some sorters. */
    public final boolean groupAreasWhenSorting;
    
    /** Horizontal spacing between two consecutive lifelines. */
    public final double lifelineSpacing;
    /** Vertical spacing between two consecutive layers of messages. */
    public final double messageSpacing;
    /** Space to be left between labels and labeled elements. */
    public final double labelSpacing;
    /** The height of lifeline headers. */
    // TODO: This should actually be specific to each lifeline.
    public final double lifelineHeaderHeight;
    /** The height of the header of combined fragments. */
    // TODO: We should rather use a proper padding instead of this and the following value.
    public final double areaHeaderHeight;
    /** The minimum height of executions. */
    public final double minExecutionHeight;
    /** The width of executions. */
    public final double executionWidth;
    /** The width of timing observations. */
    public final double timeObservationWidth;
    /** The offset between two nested areas. */
    public final double containmentOffset;
    
    // CHECKSTYLEON VisibilityModifier
    
    
    /**
     * Creates a new instance intialized based on the properties configured for the given interaction node.
     * 
     * @param interactionNode
     *            parent node of the graph that is to be laid out.
     */
    public LayoutContext(final ElkNode parentNode) {
        elkgraph = parentNode;
        
        labelAlignment = parentNode.getProperty(
                SequenceDiagramOptions.LABEL_ALIGNMENT);
        sortingStrategy = parentNode.getProperty(
                SequenceDiagramOptions.LIFELINE_SORTING_STRATEGY);
        groupAreasWhenSorting = parentNode.getProperty(
                SequenceDiagramOptions.GROUP_AREAS);
        
        lifelineSpacing = parentNode.getProperty(
                SequenceDiagramOptions.SPACING_LIFELINE);
        messageSpacing = parentNode.getProperty(
                SequenceDiagramOptions.SPACING_MESSAGE);
        labelSpacing = parentNode.getProperty(
                SequenceDiagramOptions.SPACING_LABEL);
        lifelineHeaderHeight = parentNode.getProperty(
                SequenceDiagramOptions.SIZE_LIFELINE_HEADER_HEIGHT);
        areaHeaderHeight = parentNode.getProperty(
                SequenceDiagramOptions.SIZE_AREA_HEADER_HEIGHT);
        minExecutionHeight = parentNode.getProperty(
                SequenceDiagramOptions.SIZE_MIN_EXECUTION_HEIGHT);
        executionWidth = parentNode.getProperty(
                SequenceDiagramOptions.SIZE_EXECUTION_WIDTH);
        timeObservationWidth = parentNode.getProperty(
                SequenceDiagramOptions.SIZE_TIME_OBSERVATION_WIDTH);
        containmentOffset = parentNode.getProperty(
                SequenceDiagramOptions.CONTAINMENT_OFFSET);
    }
}