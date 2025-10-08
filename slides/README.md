# How We Learn About Your Existing Application - Slide Deck

## Overview

This directory contains a one-page, image-led PowerPoint presentation titled "How We Learn About Your Existing Application" with the subtitle "Know Before You Build." The presentation uses professional styling with a clean design and includes animations.

## Files

- **How_We_Learn_OnePager_Animated.pptx** - The main PowerPoint presentation file
- **assets/how-we-learn-onepager.svg** - SVG export of the core vector illustration for reference/editing

## Design Specifications

### Color Palette
- **Accent Blue**: #3B82F6
- **Light Blue Tints**: #93C5FD, #60A5FA
- **Card Background**: #F3F4F6 (neutral)
- **Text**: #111827 (dark gray)
- **Subtext**: #374151 (medium gray)

### Layout
The slide follows a left-to-right flow with:
1. **Top-left**: Title and subtitle
2. **Center**: Four step cards with arrows between them
3. **Right side**: "What You Get" panel
4. **Bottom-left**: Footer caption

### Step Cards Content

1. **Stakeholder Mapping**
   - Label: "Who needs what — and why"
   - Icon: Faces/speech bubbles

2. **Current State**
   - Label: "Apps, data, tech — one map"
   - Icon: Server rack + DB cylinder

3. **Business Process**
   - Label: "How work really flows"
   - Icon: Conveyor belt + boxes

4. **Reverse Engineering**
   - Label: "Trace data and code to the truth"
   - Icon: Magnifying glass over code

### "What You Get" Panel
Lists four key outcomes:
- Shared understanding
- Living system map
- Pain heatmap
- Practical change plan

### Footer
"Outcome: clarity → confidence → faster value"

## Animation Sequence

To configure animations in PowerPoint (via Animation Pane):

1. **Title + subtitle**: Appear (On Click, 0.25s)
2. **Step 1 group**: Wipe From Left (On Click, 0.5s)
3. **Arrow 1**: Wipe From Left (After Previous, 0.35s)
4. **Step 2 group**: Wipe From Left (On Click, 0.5s)
5. **Arrow 2**: Wipe From Left (After Previous, 0.35s)
6. **Step 3 group**: Wipe From Left (On Click, 0.5s)
7. **Arrow 3**: Wipe From Left (After Previous, 0.35s)
8. **Step 4 group**: Wipe From Left (On Click, 0.5s)
9. **"What You Get" panel**: Fade (On Click, 0.4s)
10. **Each bullet**: Appear (On Click for each, 0.2s)

**Optional enhancements:**
- Single Pulse on one face icon after entrance
- One-time 15° Spin on the magnifier after entrance

### How to Add/Edit Animations

1. Open the .pptx file in Microsoft PowerPoint
2. Go to **Animations** tab
3. Select **Animation Pane** to view and edit
4. Select each element and apply the animation as specified above
5. Adjust timing using **Start** (On Click/After Previous) and **Duration** settings

## Editing the Slide

### Changing Colors
1. Select any shape or text element
2. Use **Format** tab > **Shape Fill** or **Text Fill**
3. Enter the hex color codes listed above

### Swapping Icons
1. Select the icon you want to replace
2. Go to **Insert** > **Icons**
3. Search for desired icon (e.g., "user", "server", "process", "magnifying glass")
4. Insert and adjust size/position to match existing layout
5. Apply colors: fill with blue tints, stroke with accent blue

### Editing Text
- Click on any text box to edit content
- Maintain font sizes and weights for consistency
- Step card titles: 14pt Bold
- Step card labels: 10pt Regular
- Main title: 32pt Bold
- Subtitle: 18pt

### Maintaining Vector Quality
- Use PowerPoint's built-in shapes and icons whenever possible
- Avoid raster images (PNG, JPG) for scalability
- When inserting icons, prefer SVG format or PowerPoint's icon library

## Speaker Notes

The slide includes speaker notes to guide presentation:

> "We start by listening: Stakeholder Mapping clarifies who's involved, what success means for them, and current pain points. Next we baseline the Current State — apps, data, and tech on one map. Then we walk the Business Process — how work actually flows. Finally, we Reverse Engineer key areas — tracing data flows, databases, and code paths to confirm the facts. Outcome: a shared understanding, a living system map, a pain heatmap, and a practical change plan. This lowers risk and speeds delivery."

To view/edit speaker notes:
1. In PowerPoint, go to **View** > **Notes Page**
2. Or use the Notes pane at the bottom of the slide editor

## Requirements

- Microsoft PowerPoint (Microsoft 365 desktop recommended)
- The presentation is designed for 16:9 aspect ratio

## Usage

1. Open **How_We_Learn_OnePager_Animated.pptx** in PowerPoint
2. Review and configure animations as needed
3. Practice the presentation flow with animations
4. Refer to speaker notes during presentation

## Support

For questions or modifications, refer to:
- PowerPoint's built-in help (F1)
- Animation Pane documentation
- Insert > Icons for additional vector graphics
