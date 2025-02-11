package cz.p;

public class MolCanvas_methods {

    // distances

    public static float dist2D(float x1, float y1, float x2, float y2) {
        float dist = (float) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return dist;
    }

    public static float dist3D(float x1, float y1, float z1, float x2, float y2, float z2) {
        float dist = (float) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        return dist;
    }

    // rotations

    public static float rotAtomX_x(float x, float y, float z, double phi) {
        float x_new = x;
        return x_new;
    }

    public static float rotAtomY_x(float x, float y, float z, double phi) {
        float y_new = y * (float) Math.cos(phi) - z * (float) Math.sin(phi);
        return y_new;
    }

    public static float rotAtomZ_x(float x, float y, float z, double phi) {
        float z_new = y * (float) Math.sin(phi) + z * (float) Math.cos(phi);
        return z_new;
    }

    public static float rotAtomX_y(float x, float y, float z, double phi) {
        float x_new = x * (float) Math.cos(phi) + z * (float) Math.sin(phi);
        return x_new;
    }

    public static float rotAtomY_y(float x, float y, float z, double phi) {
        float y_new = y;
        return y_new;
    }

    public static float rotAtomZ_y(float x, float y, float z, double phi) {
        float z_new = -x * (float) Math.sin(phi) + z * (float) Math.cos(phi);
        return z_new;
    }

    public static float rotAtomX_z(float x, float y, float z, double phi) {
        float x_new = x * (float) Math.cos(phi) - y * (float) Math.sin(phi);
        return x_new;
    }

    public static float rotAtomY_z(float x, float y, float z, double phi) {
        float y_new = x * (float) Math.sin(phi) + y * (float) Math.cos(phi);
        return y_new;
    }

    public static float rotAtomZ_z(float x, float y, float z, double phi) {
        float z_new = z;
        return z_new;
    }

    // translations

    public static float translAtom_x(float x, float x_t) {
        float x_new = x + x_t;
        return x_new;
    }

    public static float translAtom_y(float y, float y_t) {
        float y_new = y + y_t;
        return y_new;
    }

    public static float translAtom_z(float z, float z_t) {
        float z_new = z + z_t;
        return z_new;
    }

    // zoom

    public static float zoomAtomX_pix(float x_pix, float zoom_scale) {
        float x_pix_new = x_pix * zoom_scale;
        return x_pix_new;
    }

    public static float zoomAtomY_pix(float y_pix, float zoom_scale) {
        float y_pix_new = y_pix * zoom_scale;
        return y_pix_new;
    }

    public static float zoomReset(float zoom_scale_old, float factor) {
        float zoom_scale = zoom_scale_old + factor;
        return zoom_scale;
    }

    // conversions

    public static float AtomX_pix(float x_Ang, float conv, float width_pix, float zoom_scale) {
        float x_pix = x_Ang * conv * zoom_scale + width_pix * 0.5f;
        return x_pix;
    }

    public static float AtomY_pix(float y_Ang, float conv, float height_pix, float zoom_scale) {
        float y_pix = height_pix * 0.5f - y_Ang * conv * zoom_scale;
        return y_pix;
    }

    public static float AtomX_Ang(float x_pix, float conv, float width_pix, float zoom_scale) {
        float x_Ang = (x_pix - width_pix * 0.5f) / (conv * zoom_scale);
        return x_Ang;
    }

    public static float AtomY_Ang(float y_pix, float conv, float height_pix, float zoom_scale) {
        float y_Ang = (-y_pix + height_pix * 0.5f) / (conv * zoom_scale);
        return y_Ang;
    }

    public static float Radius_pix(float r_Ang, float conv, float radius_scale, float zoom_scale, float z12_Ang) {
        float r_pix = r_Ang * conv * zoom_scale * radius_scale * Object_persp(z12_Ang);
        return r_pix;
    }

    public static float Radius_Ang(float r_pix, float conv, float radius_scale, float zoom_scale, float z12_Ang) {
        float r_Ang = r_pix / (conv * zoom_scale * radius_scale * Object_persp(z12_Ang));
        return r_Ang;
    }

    public static float Bond_pix(float bond_pix, float zoom_scale, float z12_Ang) {
        float thickness_pix = bond_pix * zoom_scale * Object_persp(z12_Ang);
        return thickness_pix;
    }

    public static float Text_pix(float text_pix, float zoom_scale, float z12_Ang) {
        float size_pix = text_pix * zoom_scale * Object_persp(z12_Ang);
        return size_pix;
    }

    public static float Object_persp(float z12_Ang) {
        float z_perspective = 1.0f;
        if (z12_Ang == 0) {
            z_perspective = 1;
        } else if (z12_Ang > 0) {
            z_perspective = 1 + MolCanvas_preferences.get().getValue("persp_scale") * z12_Ang;
        } else if (z12_Ang < 0) {
            z_perspective = 1 / (1 - MolCanvas_preferences.get().getValue("persp_scale") * z12_Ang);
        }
        return z_perspective;
    }

    // minimum and maximum

    public static float minValue(float min_old, float min_new) {
        float minValue = Float.min(min_old, min_new);
        return minValue;
    }

    public static float maxValue(float max_old, float max_new) {
        float maxValue = Float.max(max_old, max_new);
        return maxValue;
    }

    // elements
    public static float getElementRadius(String Element) {
        float r_Ang = MolCanvas_preferences.get().getValue("r_" + Element);
        return r_Ang;
    }

    public static int getElementColor(String Element) {
        int color = MolCanvas_preferences.get().getIntValue("color_" + Element);
        return color;
    }

    public static int getElementTextColor(String Element) {
        int text_color = MolCanvas_preferences.get().getIntValue("text_color_" + Element);
        return text_color;
    }

    // strings
    public static int getCharOcc(String word, char letter) {
        int occ = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                occ++;
            }
        }
        return occ;
    }
}
