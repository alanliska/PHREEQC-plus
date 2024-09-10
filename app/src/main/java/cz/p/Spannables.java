package cz.p;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

// the last colorization within the function is the most important (will be applied as the last)
// rule: the first are the least important colorizations, overriden by the last ones

public class Spannables extends MainActivity {

    public static Spannable colorized_numbers(final String text) {
        SpannableString spannable = new SpannableString(text);
        // when the white background span is applied, the text selection is not visible (only the non-spanned parts)
        Integer argb_back = Color.WHITE;

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        return spannable;
    }

    public static Spannable colorized_phreeqc(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_basic = {" ABS", " AND ", " AND\t", " ARCTAN", " ASC", " CEIL", " CHR$", " COS", " DATA ", " DATA\t", " DIM", " ERASE", " ELSE", " EOL$", " EXP", " FLOOR", " FOR ", " FOR\t", " NEXT ", " NEXT\t", " GOSUB ", " GOSUB\t", " GOTO ", " GOTO\t", " IF ", " IF\t", " INSTR", " LEN", " LOG", " LOG10", " LTRIM", " MID$", " MOD", " ON ", " ON\t", " OR ", " OR\t", " PAD", " READ ", " READ\t", " REM ", " REM\t", " RESTORE", " RETURN", " RTRIM", " SGN", " SIN", " SQR", " SQRT", " STR_E$", " STR_F$", " STR$", " STR_", " TAN", " TRIM", " VAL", " WEND ", " WEND\t", " WHILE ", " WHILE\t", " XOR", " abs", " and ", " and\t", " arctan", " asc", " ceil", " chr$", " cos", " data ", " data\t", " dim", " erase", " else", " eol$", " exp", " floor", " for ", " for\t", " next ", " next\t", " gosub ", " gosub\t", " goto ", " goto\t", " if ", " if\t", " instr", " len", " log", " log10", " ltrim", " mid$", " mod", " on ", " on\t", " or ", " or\t", " pad", " read ", " read\t", " rem ", " rem\t", " restore", " return", " rtrim", " sgn", " sin", " sqr", " sqrt", " str_e$", " str_f$", " str$", " str_", " tan", " trim", " val", " wend ", " wend\t", " while ", " while\t", " xor"};
        Integer argb_basic = Color.parseColor("#A52A2A");
        Integer argb_basic_back = Color.parseColor("#FFE797");
        for (String word : words_basic) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_basic),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new BackgroundColorSpan(argb_basic_back),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        String[] words_brown = {"-description ", "-description\t", "-diff_c ", "-diff_c\t", "-gas", "-graph_sy ", "-graph_sy\t", "-graph_x ", "-graph_x\t", "-graph_y ", "-graph_y\t", "-lk_phase ", "-lk_phase\t", "-lk_species", "-misc1 ", "-misc1\t", "-misc2 ", "-misc2\t", "-osmotic", "-step_no ", "-step_no\t", "-total_time ", "-total_time\t", "ACT", "ALK ", "ALK\t", "APHI ", "APHI\t", "CELL_NO ", "CELL_NO\t", "CHANGE_POR", "CHANGE_SURF", "Color ", "Color\t", "CURRENT_A", "DESCRIPTION ", "DESCRIPTION\t", "DH_AV ", "DH_AV\t", "DIFF_C ", "DIFF_C\t", "DIST ", "DIST\t", "EDL", "EDL_SPECIES", "EOL$", "EPS_R", "EQUI", "EXISTS", "GAS", "GAS_P", "GAS_VM", "GET", "GET_POR", "GFW", "GRAPH_SY ", "GRAPH_SY\t", "GRAPH_X ", "GRAPH_X\t", "GRAPH_Y ", "GRAPH_Y\t", "KAPPA", "KIN", "KINETICS_FORMULA$", "KIN_DELTA", "KIN_TIME", "LA", "LG", "LIST_S_S", "LK_NAMED ", "LK_NAMED\t", "LK_PHASE ", "LK_PHASE\t", "LK_SPECIES", "LM", "MCD_JCONC", "MCD_JTOT", "MISC1", "MISC2", "MOL", "OSMOTIC", "PARM", "PHASE_FORMULA$", "PHASE_VM", "POT_V", "PR_P", "PR_PHI", "PUNCH ", "PUNCH\t", "PUT", "RHO", "RHO_0", "RXN", "SC", "SIM_NO", "SIM_TIME", "SOLN_VOL ", "SOLN_VOL\t", "SR ", "SR\t", "STEP_NO", "SUM_GAS", "SUM_S_S", "SUM_SPECIES", "SURF", "SYS", "S_S", "TC", "TK", "TOT", "TOTAL_TIME", "TOTMOLE", "VISCOS ", "VISCOS\t", "VISCOS_0 ", "VISCOS_0\t", "act", "alk", "aphi ", "aphi\t", "calc_value", "cell_no ", "cell_no\t", "change_por", "change_surf", "color ", "color\t", "current_a", "debye_length ", "debye_length\t", "delta_h_phase", "delta_h_species", "description ", "description\t", "dh_a0", "dh_bdot", "diff_c", "dist ", "dist\t", "edl", "edl_species", "eol$ ", "eol$\t", "eol_notab$ ", "eol_notab$\t", "eps_r ", "eps_r\t", "equi", "exists", "false", "gas", "gas_p ", "gas_p\t", "gas_vm", "get", "get_por", "gfw", "graph_sy ", "graph_sy\t", "graph_x ", "graph_x\t", "graph_y ", "graph_y\t", "kappa", "kin_delta", "kin_time", "kin", "kinetics_formula$ ", "kinetics_formula$\t", "la ", "la\t", "lg", "lk_phase ", "lk_phase\t", "lk_phase ", "lk_phase\t", "lk_species", "lm", "misc1 ", "misc1\t", "misc2 ", "misc2\t", "mol", "no_newlines ", "no_newlines\t", "osmotic", "parm", "phase_formula$", "phase_vm", "pot_v", "punch", "put ", "put\t", "qbrn", "rho", "rho_0", "rxn", "s_s", "sc", "sim_no ", "sim_no\t", "sim_time ", "sim_time\t", "soln_vol ", "soln_vol\t", "sr", "step_no ", "step_no\t", "sum_gas", "sum_s_s", "sum_species", "surf", "symbol ", "symbol\t", "symbol_size ", "symbol_size\t", "sys", "tc ", "tc\t", "tk ", "tk\t", "tot", "total_time ", "total_time\t", "totmole", "true", "viscos ", "viscos\t", "viscos_0 ", "viscos_0\t"};
        Integer argb_brown = Color.parseColor("#A52A2A");
        for (String word : words_brown) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_brown),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_gray = {"-alkalinity", "-all", "-append", "-isotope ", "-isotope\t", "-numerical_fixed_volume ", "-numerical_fixed_volume\t", "-solutions", "-start_time ", "-start_time\t", "Alkalinity ", "Alkalinity\t", "Brown ", "Brown\t", "Cyan ", "Cyan\t", "Lavender ", "Lavender\t", "LightSeaGreen ", "LightSeaGreen\t", "RoyalBlue ", "RoyalBlue\t", "Teal ", "Teal\t", "Tomato ", "Tomato\t", "alkalinity", "auto", "calculate", "charge", "closed", "constant", "flux ", "flux\t", "isotope ", "isotope\t", "numerical_fixed_volume ", "numerical_fixed_volume\t", "pH ", "pH\t", "pe ", "pe\t", "pitzer.dat", "set_diff_c", "solutions", "start_time ", "start_time\t", "sy_axis ", "sy_axis\t", "x_axis ", "x_axis\t", "y_axis ", "y_axis\t"};
        Integer argb_gray = Color.DKGRAY;
        for (String word : words_gray) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_gray),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_cyan = {"-ALPHAS ", "-ALPHAS\t", "-B0 ", "-B0\t", "-B1 ", "-B1\t", "-B2 ", "-B2\t", "-C0 ", "-C0\t", "-Eh ", "-Eh\t", "-Gugg_kJ ", "-Gugg_kJ\t", "-Gugg_nondim ", "-Gugg_nondim\t", "-LAMDA ", "-LAMDA\t", "-MacInnes ", "-MacInnes\t", "-Margules ", "-Margules\t", "-Millero ", "-Millero\t", "-PSI ", "-PSI\t", "-THETA ", "-THETA\t", "-ZETA ", "-ZETA\t", "-active", "-activities", "-activity_coefficients", "-activity_water", "-add_constant", "-add_logk", "-alyotropic_point", "-analytical_expression", "-axis_scale ", "-axis_scale\t", "-axis_titles ", "-axis_titles\t", "-bad_step_max ", "-bad_step_max\t", "-balances ", "-balances\t", "-bdot ", "-bdot\t", "-boundary_conditions ", "-boundary_conditions\t", "-capacitance", "-cd_music", "-cells ", "-cells\t", "-censor_mp", "-censor_species", "-charge_balance", "-chart_title ", "-chart_title\t", "-co2_coefs ", "-co2_coefs\t", "-co2_llnl_gamma ", "-co2_llnl_gamma\t", "-comp ", "-comp\t", "-comp1 ", "-comp1\t", "-comp2 ", "-comp2\t", "-connect_simulations ", "-connect_simulations\t", "-convergence_tolerance ", "-convergence_tolerance\t", "-correct_disp ", "-correct_disp\t", "-critical_point ", "-critical_point\t", "-cvode ", "-cvode\t", "-cvode_order ", "-cvode_order\t", "-cvode_steps ", "-cvode_steps\t", "-davies", "-debug_diffuse_layer ", "-debug_diffuse_layer\t", "-debug_inverse ", "-debug_inverse\t", "-debug_mass_action ", "-debug_mass_action\t", "-debug_mass_balance ", "-debug_mass_balance\t", "-debug_model ", "-debug_model\t", "-debug_prep ", "-debug_prep\t", "-debug_set ", "-debug_set\t", "-delta_h ", "-delta_h\t", "-density ", "-density\t", "-detach", "-diagonal_scale ", "-diagonal_scale\t", "-diffuse_layer ", "-diffuse_layer\t", "-diffusion_coefficient ", "-diffusion_coefficient\t", "-dispersivities ", "-dispersivities\t", "-distribution_coefficients", "-donnan ", "-donnan\t", "-dump_frequency ", "-dump_frequency\t", "-dump_restart ", "-dump_restart\t", "-dw ", "-dw\t", "-echo_input ", "-echo_input\t", "-epsilon ", "-epsilon\t", "-equilibrate ", "-equilibrate\t", "-erm_ddl ", "-erm_ddl\t", "-exchange_gammas ", "-exchange_gammas\t", "-file ", "-file\t", "-fix_current ", "-fix_current\t", "-fixed_pressure", "-fixed_volume", "-flow_direction ", "-flow_direction\t", "-force_equality", "-force_solutions", "-formula ", "-formula\t", "-gamma", "-gases", "-headings ", "-headings\t", "-high_precision ", "-high_precision\t", "-implicit ", "-implicit\t", "-initial_isotopes ", "-initial_isotopes\t", "-initial_solutions ", "-initial_solutions\t", "-initial_time ", "-initial_time\t", "-interlayer_d ", "-interlayer_d\t", "-ionic_strength ", "-ionic_strength\t", "-isotope_uncertainty ", "-isotope_uncertainty\t", "-iterations ", "-iterations\t", "-kinetic_reactants ", "-kinetic_reactants\t", "-lengths ", "-lengths\t", "-llnl_gamma ", "-llnl_gamma\t", "-log_k ", "-log_k\t", "-logfile ", "-logfile\t", "-lon_netpath ", "-lon_netpath\t", "-m ", "-m\t", "-m0 ", "-m0\t", "-mineral_water ", "-mineral_water\t", "-minimal ", "-minimal\t", "-miscibility_gap ", "-miscibility_gap\t", "-molalities ", "-molalities\t", "-mole_balance ", "-mole_balance\t", "-mp_tolerance ", "-mp_tolerance\t", "-multi_d ", "-multi_d\t", "-multiple_precision ", "-multiple_precision\t", "-new_line ", "-new_line\t", "-no_check ", "-no_check\t", "-no_edl ", "-no_edl\t", "-numerical_derivatives ", "-numerical_derivatives\t", "-omega", "-only_counter_ions ", "-only_counter_ions\t", "-other ", "-other\t", "-p_c", "-parms ", "-parms\t", "-pat_netpath", "-pe_step_size ", "-pe_step_size\t", "-percent_error", "-pitzer_exchange_gammas", "-plot_concentration_vs", "-plot_tsv_file ", "-plot_tsv_file\t", "-potential ", "-potential\t", "-pressure", "-print_cells", "-print_frequency", "-punch_cells", "-punch_frequency", "-porosities", "-range", "-redox", "-reset ", "-reset\t", "-runge_kutta ", "-runge_kutta\t", "-same_model ", "-same_model\t", "-saturation_indices ", "-saturation_indices\t", "-shifts ", "-shifts\t", "-simulation ", "-simulation\t", "-sites_units ", "-sites_units\t", "-species", "-spinodal_gap", "-stagnant ", "-stagnant\t", "-start", "-state", "-status ", "-status\t", "-steps ", "-steps\t", "-step_divide ", "-step_divide\t", "-step_size ", "-step_size\t", "-steps ", "-steps\t", "-t_c", "-temp ", "-temp\t", "-temperature ", "-temperature\t", "-tempk ", "-tempk\t", "-thermal_diffusion ", "-thermal_diffusion\t", "-time ", "-time\t", "-time_step ", "-time_step\t", "-tol ", "-tol\t", "-tolerance ", "-tolerance\t", "-totals ", "-totals\t", "-uncertainty ", "-uncertainty\t", "-uncertainty_water ", "-uncertainty_water\t", "-units ", "-units\t", "-use_etheta ", "-use_etheta\t", "-volume ", "-volume\t", "-viscosity ", "-viscosity\t", "-warnings ", "-warnings\t", "-water", "Black ", "Black\t", "Blue ", "Blue\t", "CHARGE_BALANCE", "Circle ", "Circle\t", "DH_A ", "DH_A\t", "DH_B ", "DH_B\t", "Diamond ", "Diamond\t", "GAMMA", "Green ", "Green\t", "HDash ", "HDash\t", "M ", "M\t", "M0 ", "M0\t", "MU", "Magenta ", "Magenta\t", "None ", "None\t", "Orange ", "Orange\t", "PERCENT_ERROR ", "PERCENT_ERROR\t", "PLOT_XY ", "PLOT_XY\t", "PRESSURE", "Plus ", "Plus\t", "Red ", "Red\t", "SI", "STEP ", "STEP\t", "Square ", "Square\t", "Star ", "Star\t", "THETA", "TIME ", "TIME\t", "Thompson ", "Thompson\t", "Triangle ", "Triangle\t", "TriangleDown ", "TriangleDown\t", "VDash ", "VDash\t", "XCross ", "XCross\t", "Yellow ", "Yellow\t", "ZETA ", "ZETA\t", "active ", "active\t", "activities", "activity_coefficients", "activity_water", "add_constant", "add_logk", "alyotropic_point", "analytical_expression", "axis_scale ", "axis_scale\t", "axis_titles ", "axis_titles\t", "backward", "bad_step_max ", "bad_step_max\t", "balances ", "balances\t", "bdot ", "bdot\t", "boundary_conditions ", "boundary_conditions\t", "capacitance", "cd_music", "cells ", "cells\t", "censor_mp", "censor_species", "charge_balance", "chart_title ", "chart_title\t", "co2_coefs ", "co2_coefs\t", "co2_llnl_gamma ", "co2_llnl_gamma\t", "comp ", "comp\t", "comp1 ", "comp1\t", "comp2 ", "comp2\t", "connect_simulations ", "connect_simulations\t", "convergence_tolerance ", "convergence_tolerance\t", "correct_disp ", "correct_disp\t", "correct_GC ", "correct_GC\t", "critical_point ", "critical_point\t", "cvode ", "cvode\t", "cvode_order ", "cvode_order\t", "cvode_steps ", "cvode_steps\t", "davies", "debug_diffuse_layer ", "debug_diffuse_layer\t", "debug_inverse ", "debug_inverse\t", "debug_mass_action ", "debug_mass_action\t", "debug_mass_balance ", "debug_mass_balance\t", "debug_model ", "debug_model\t", "debug_prep ", "debug_prep\t", "debug_set ", "debug_set\t", "delta_h ", "delta_h\t", "density", "detach", "diagonal_scale ", "diagonal_scale\t", "diffuse_layer ", "diffuse_layer\t", "diffusion_coefficient ", "diffusion_coefficient\t", "diffusion_only", "dispersivities ", "dispersivities\t", "distance ", "distance\t", "distribution_coefficients", "donnan ", "donnan\t", "dump_frequency ", "dump_frequency\t", "dump_restart ", "dump_restart\t", "dw ", "dw\t", "echo_input ", "echo_input\t", "equilibrate ", "equilibrate\t", "erm_ddl ", "erm_ddl\t", "exchange_gammas ", "exchange_gammas\t", "file ", "file\t", "fix_current ", "fix_current\t", "fixed_pressure", "fixed_volume", "flow_direction ", "flow_direction\t", "force_equality", "force_solutions", "formula ", "formula\t", "forward", "gamma", "gases", "headings ", "headings\t", "high_precision ", "high_precision\t", "implicit ", "implicit\t", "initial_isotopes ", "initial_isotopes\t", "initial_solutions ", "initial_solutions\t", "initial_time ", "initial_time\t", "interlayer_d ", "interlayer_d\t", "ionic_strength ", "ionic_strength\t", "isotope_uncertainty ", "isotope_uncertainty\t", "iterations ", "kinetic_reactants ", "kinetic_reactants\t", "lengths", "llnl_gamma ", "llnl_gamma\t", "log_k ", "log_k\t", "logfile ", "logfile\t", "lon_netpath ", "lon_netpath\t", "m ", "m\t", "m0 ", "m0\t", "mineral_water ", "mineral_water\t", "minimal ", "minimal\t", "miscibility_gap ", "miscibility_gap\t", "molalities ", "molalities\t", "mole_balance ", "mole_balance\t", "mp_tolerance ", "mp_tolerance\t", "mu", "multi_d ", "multi_d\t", "multiple_precision ", "multiple_precision\t", "new_line ", "new_line\t", "no_check", "no_edl ", "no_edl\t", "numerical_derivatives ", "numerical_derivatives\t", "only_counter_ions ", "only_counter_ions\t", "other ", "other\t", "p_c", "parms ", "parms\t", "pat_netpath", "pe_step_size ", "pe_step_size\t", "percent_error", "pitzer_exchange_gammas", "plot_concentration_vs ", "plot_concentration_vs\t", "plot_csv_file ", "plot_csv_file\t", "plot_xy ", "plot_xy\t", "potential ", "potential\t", "pressure", "print_cells", "print_frequency ", "print_frequency\t", "punch_cells", "punch_frequency ", "punch_frequency\t", "porosities", "range", "redox", "reset ", "reset\t", "runge_kutta ", "runge_kutta\t", "same_model ", "same_model\t", "saturation_indices ", "saturation_indices\t", "shifts ", "shifts\t", "si ", "si\t", "simulation", "sites_units", "species", "spinodal_gap", "stagnant ", "stagnant\t", "start", "state", "status", "steps ", "steps\t", "step_divide ", "step_divide\t", "step_size ", "step_size\t", "steps ", "steps\t", "t_c ", "t_c\t", "temp ", "temp\t", "temperature ", "temperature\t", "tempk ", "tempk\t", "thermal_diffusion ", "thermal_diffusion\t", "time ", "time\t", "time_step ", "time_step\t", "tol ", "tol\t", "tolerance ", "tolerance\t", "totals ", "totals\t", "uncertainty", "uncertainty_water", "units ", "units\t", "use_etheta ", "use_etheta\t", "vm", "volume", "warnings ", "warnings\t", "water"};
        Integer argb_cyan = Color.parseColor("#7AD5E1");
        for (String word : words_cyan) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_cyan),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new android.text.style.StyleSpan(Typeface.BOLD),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_blue = {"ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION ", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY", "-calculate_values", "-dump ", "-dump\t", "-end ", "-end\t", "-equilibrium_phases ", "-equilibrium_phases\t", "-exchange ", "-exchange\t", "-gas_phase ", "-gas_phase\t", "-inverse_modeling ", "-inverse_modeling\t", "-isotope_alphas ", "-isotope_alphas\t", "-isotope_ratios ", "-isotope_ratios\t", "-isotopes ", "-isotopes\t", "-kinetics ", "-kinetics\t", "-phases", "-reaction ", "-reaction\t", "-reaction_pressure ", "-reaction_pressure\t", "-reaction_temperature ", "-reaction_temperature\t", "-solid_solutions ", "-solid_solutions\t", "-solution ", "-solution\t", "-surface", "-user_graph ", "-user_graph\t", "-user_print ", "-user_print\t", "-user_punch ", "-user_punch\t", "DUMP", "KINETICS", "KINETICS_MIX", "KINETICS_MODIFY", "LLNL_AQUEOUS_MODEL_PARAMETERS", "PRINT", "SIT", "calculate_values", "dump ", "dump\t", "end ", "end\t", "equilibrium_phases ", "equilibrium_phases\t", "exchange ", "exchange\t", "gas_phase ", "gas_phase\t", "inverse_modeling ", "inverse_modeling\t", "isotope_alphas ", "isotope_alphas\t", "isotope_ratios ", "isotope_ratios\t", "isotopes ", "isotopes\t", "kinetics ", "kinetics\t", "phases", "print", "reaction ", "reaction\t", "reaction_pressure ", "reaction_pressure\t", "reaction_temperature ", "reaction_temperature\t", "save", "solid_solutions ", "solid_solutions\t", "solution ", "solution\t", "surface", "user_graph", "user_print", "user_punch"};
        Integer argb_blue = Color.BLUE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        // currently not working - not perfect analogy with words_comments
        //
//        String[] words_quotations = {"\'"};
//        Integer argb_quotations = Color.MAGENTA;
//        for (String word : words_quotations) {
//            int substringStart = 0;
//            int start;
//            int i = 0;
//            int prevQuot = 0;
//            int nextQuot = 0;
//            while ((start = text.indexOf(word, substringStart)) >= 0) {
//                i++;
//                if (i == 1){
//                    prevQuot = text.indexOf(word,start);
//                    substringStart = prevQuot;
//                } else if (i > 1){
//                    nextQuot = text.indexOf(word,prevQuot);
//                    if (nextQuot != -1) {
//                        spannable.setSpan(
//                                new ForegroundColorSpan(argb_quotations), prevQuot, nextQuot,
//                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                        );
//                        substringStart = nextQuot+1;
//                        prevQuot = nextQuot+1;
//                    } else {
//                        spannable.setSpan(
//                                new ForegroundColorSpan(argb_quotations), prevQuot, text.length(),
//                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                        );
//                        substringStart = start+word.length();
//                    }
//                }
//            }
//        }

        String[] words_quotations1 = {"\\'(.*?)\\'"};
        Integer argb_quotations1 = Color.MAGENTA;
        for (String word : words_quotations1) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int neqtQuot1 = text.indexOf(word,start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (neqtQuot1 != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_quotations1), start, neqtQuot1,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                );
                    substringStart = neqtQuot1;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_quotations1), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                );
                    substringStart = start+word.length();
                }
            }
        }

        String[] words_comment = {"#", "REM"};
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n",start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (endOfLine != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                );
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                                );
                    substringStart = start+word.length();
                }
            }
        }

        return spannable;
    }

    public static Spannable colorized_fastchem(final String text) {
        SpannableString spannable = new SpannableString(text);

        String[] words_blue = {"a1 ", "a2 ", "a3 ", "a4 ", "a5 ", "logK ", "lnK ", "T "};
        Integer argb_blue = Color.BLUE;
        Integer argb_back = Color.WHITE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_comment = {"#"};
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n",start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (endOfLine != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = start+word.length();
                }
            }
        }

        return spannable;
    }

    public static Spannable colorized_mopac(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_brown = {"++", "0SCF", "1ELECTRON", "1SCF", "A0", "ADD-H", "AIGIN", "AIGOUT", "ALLBONDS", "ALLVEC", "ALT_A", "ANGSTROMS", "AUTOSYM", "AUX", "BANANA", "BAR", "BCC", "BIGCYCLES", "BONDS", "BZ", "C.A.S.", "C.I.", "C.I.D.", "CAMP", "CARTAB", "CHAINS", "CHARGE", "CHARGES", "CHARST", "CHECK", "CIS", "CISD", "CISDT", "COMPARE", "COMPFG", "COSCCH", "COSWRT", "CUTOFF", "CUTOFP", "CUTOFS", "CVB", "CYCLES", "DAMP", "DATA", "DCART", "DDMAX", "DDMIN", "DEBUG", "DEBUGPULAY", "DENOUT", "DENOUTF", "DENSITY", "DERI1", "DERI2", "DERITR", "DERIV", "DERNVO", "DFORCE", "DFP", "DIPOLE", "DISEX", "DISP", "DMAX", "DRC", "DUMP", "ECHO", "EIGEN", "EIGS", "ENPART", "EPS", "ESP", "ESPGRID", "ESR", "EXCITED", "EXTERNAL", "FIELD", "FILL", "FLEPO", "FMAT", "FOCK", "FORCE", "FORCETS", "FREQCY", "GEO-OK", "GEO_DAT", "GEO_REF", "GNORM", "GRADIENTS", "GRAPH", "GRAPHF", "H-PRIORITY", "HCORE", "HESS", "HESSIAN", "HTML", "HYPERFINE", "INT", "INVERT", "IONIZE", "IRC", "ISOTOPE", "ITER", "ITRY", "IUPD", "KINETIC", "KING", "LARGE", "LET", "LEWIS", "LINMIN", "LOCAL", "LOCATE-TS", "LOG", "MAXCI", "MECI", "MERS", "METAL", "MICROS", "MINI", "MINMEP", "MMOK", "MODE", "MOLDAT", "MOLSYM", "MOPAC", "MOZYME", "MRCI", "MS", "MULLIK", "N**2", "NLLSQ", "NOANCI", "NOCOMMENTS", "NOLOG", "NOMM", "NONR", "NOOPT", "NOREOR", "NORESEQ", "NOSWAP", "NOSYM", "NOTHIEL", "NOTXT", "NOXYZ", "NSPA", "NSURF", "OLDCAV", "OLDENS", "OLDFPC", "OLDGEO", "OMIN", "OPEN", "OPT", "OPT-X", "OUTPUT", "P", "PDB=", "PDBOUT", "PECI", "PI", "PKA", "PL", "PMEP", "PMEPR", "POINT", "POINT1", "POINT2", "POLAR", "POTWRT", "POWSQ", "PRECISE", "P=", "PRNT", "PRTCHAR", "PRTINT", "PRTMEP", "PRTXYZ", "PULAY", "QMMM", "QPMEP", "RABBIT", "RAMA", "RAPID", "RE-LOCAL", "RECALC", "RELSCF", "REORTH", "RESEQ", "RESIDUES", "RESTART", "RHF", "RMAX", "RMIN", "ROOT", "RSCAL", "RSOLV", "SADDLE", "SCALE", "SCFCRT", "SCINCR", "SETPI", "SETUP", "SHIFT", "SIGMA", "SITE", "SLOG", "SLOPE", "SMOOTH", "SNAP", "SPARKLE", "START_RES", "STATIC", "STEP", "STEP1", "STEP2", "STO3G", "SUPER", "SYBYL", "SYMAVG", "SYMMETRY", "SYMOIR", "SYMTRZ", "T", "T-PRIORITY", "TDIP", "THERMO", "TIMES", "TRANS", "TS", "UHF", "VDW", "VDWM", "VECTORS", "VELOCITY", "WILLIAMS", "WRTCI", "WRTCONF", "X-PRIORITY", "XENO", "XYZ", "Z", "THREADS"};
        Integer argb_brown = Color.parseColor("#A52A2A");
        for (String word : words_brown) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_brown),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_cyan = {"EF ", "BFGS", "LBFGS", "L-BFGS"};
        Integer argb_cyan = Color.parseColor("#7AD5E1");
        for (String word : words_cyan) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_cyan),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new android.text.style.StyleSpan(Typeface.BOLD),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_blue = {"CHARGE", "SPIN", "DOUBLET", "SINGLET", "TRIPLET", "QUARTET", "QUINTET", "SEXTET", "SEPTET", "OCTET", "NONET", "BIRADICAL"};
        Integer argb_blue = Color.BLUE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_basic = {"AM1", "PM3", "PM6", "PM6-D3", "PM6-D3H4", "PM6-D3H4X", "PM6-DH+", "PM6-DH2", "PM6-DH2X", "PM7", "PM7-TS", "RM1", "INDO", "MNDO", "MNDOD"};
        Integer argb_basic = Color.parseColor("#A52A2A");
        Integer argb_basic_back = Color.parseColor("#FFE797");
        for (String word : words_basic) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_basic),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new BackgroundColorSpan(argb_basic_back),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        return spannable;
    }

    public static Spannable colorized_bash(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_green = {"cd ", "export ", "acpid ", "adjtimex ", "ar ", "arch ", "arp ", "arping ", "ash ", "awk ", "basename ", "bc ", "blkdiscard ", "blockdev ", "brctl ", "bunzip2 ", "bzcat ", "bzip2 ", "cal ", "cat ", "chgrp ", "chmod ", "chown ", "chroot ", "chvt ", "clear ", "cmp ", "cp ", "cpio ", "cttyhack ", "cut ", "date ", "dc ", "dd ", "deallocvt ", "depmod ", "devmem ", "df ", "diff ", "dirname ", "dmesg ", "dnsdomainname ", "dos2unix ", "du ", "dumpkmap ", "dumpleases ", "echo ", "egrep ", "env ", "expand ", "expr ", "factor ", "fallocate ", "false ", "fatattr ", "fgrep ", "find ", "fold ", "free ", "freeramdisk ", "fsfreeze ", "fstrim ", "ftpget ", "ftpput ", "getopt ", "getty ", "grep ", "groups ", "gunzip ", "gzip ", "halt ", "head ", "hexdump ", "hostid ", "hostname ", "httpd ", "hwclock ", "i2cdetect ", "i2cdump ", "i2cget ", "i2cset ", "id ", "ifconfig ", "ifdown ", "ifup ", "init ", "insmod ", "ionice ", "ip ", "ipcalc ", "ipneigh ", "kill ", "killall ", "klogd ", "last ", "less ", "link ", "linux32 ", "linux64 ", "linuxrc ", "ln ", "loadfont ", "loadkmap ", "logger ", "login ", "logname ", "logread ", "losetup ", "ls ", "lsmod ", "lsscsi ", "lzcat ", "lzma ", "lzop ", "md5sum ", "mdev ", "microcom ", "mkdir ", "mkdosfs ", "mke2fs ", "mkfifo ", "mknod ", "mkpasswd ", "mkswap ", "mktemp ", "modinfo ", "modprobe ", "more ", "mount ", "mt ", "mv ", "nameif ", "nc ", "netstat ", "nl ", "nologin ", "nproc ", "nsenter ", "nslookup ", "nuke ", "od ", "openvt ", "partprobe ", "paste ", "patch ", "pidof ", "ping ", "ping6 ", "pivot_root ", "poweroff ", "printf ", "ps ", "pwd ", "rdate ", "readlink ", "realpath ", "reboot ", "renice ", "reset ", "resume ", "rev ", "rm ", "rmdir ", "rmmod ", "route ", "rpm ", "rpm2cpio ", "run-init ", "run-parts ", "sed ", "seq ", "setkeycodes ", "setpriv ", "setsid ", "sh ", "sha1sum ", "sha256sum ", "sha512sum ", "shred ", "shuf ", "sleep ", "sort ", "ssl_client ", "start-stop-daemon ", "stat ", "strings ", "stty ", "svc ", "svok ", "swapoff ", "swapon ", "switch_root ", "sync ", "sysctl ", "syslogd ", "tac ", "tail ", "tar ", "taskset ", "tee ", "telnet ", "test ", "tftp ", "time ", "timeout ", "top ", "touch ", "tr ", "traceroute ", "traceroute6 ", "true ", "truncate ", "tty ", "ubirename ", "udhcpc ", "udhcpd ", "uevent ", "umount ", "uname ", "uncompress ", "unexpand ", "uniq ", "unix2dos ", "unlink ", "unlzma ", "unshare ", "unxz ", "unzip ", "uptime ", "usleep ", "uudecode ", "uuencode ", "vconfig ", "vi ", "w ", "watch ", "watchdog ", "wc ", "wget ", "which ", "who ", "whoami ", "xargs ", "xxd ", "xz ", "xzcat ", "yes ", "zcat ", "obabel ", "dftb ", "qcxms ", "modes ", "xbbc ", "xbvm ", "plotms ", "stda ", "xtb ", "xtb4stda ", "waveplot ", "chimescalc ", "chemsol ", "mopac ", "mopac-makpol ", "fastchem ", "mopac-param ", "phreeqc ", "transpose ", "cpx ", "dftd4 ", "multicharge ", "numsa-exe ", "s-dftd3 ", "tblite ", "toybox "};
        Integer argb_green = Color.parseColor("#66BB6A");
        for (String word : words_green) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_green),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_comment = {"#", "!"};
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n",start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (endOfLine != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = start+word.length();
                }
            }
        }

        return spannable;
    }

    public static Spannable colorized_x11basic(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_basic = {"ABS(", "ABSOLUTE", "ACOS(", "ACOSH(", "ADD", "ADD(", "AFTER", "ALERT", "AND", "AND(", "ANDROID?", "ARG(", "ARID$(", "ARIE$(", "ARRAYCOPY", "ARRAYFILL", "ARRPTR(", "ASC(", "ASIN(", "ASINH(", "AT(", "ATAN(", "ATAN2(", "ATANH(", "ATN(", "BCHG(", "BCLR(", "BEEP", "BELL", "BGET", "BIN$(", "BLOAD", "BMOVE", "BOTTOMW", "BOUNDARY", "BOX", "BPUT", "BREAK", "BSAVE", "BSET(", "BTST(", "BWTD$(", "BWTE$(", "BYTE(", "CALL", "CALL(", "CALL$(", "CALLD(", "CARD(", "CASE", "CBRT(", "CEIL(", "CGI", "CHAIN", "CHDIR", "CHMOD", "CHR$(", "CINT(", "CIRCLE", "CLEAR", "CLEARW", "CLIP", "CLOSE", "CLOSEW", "CLR", "CLS", "COLOR", "COLOR(", "COLOR_RGB(", "COLS", "COMBIN(", "COMPRESS$(", "CONJ(", "CONNECT", "CONT", "CONTINUE", "COPY_AREA", "COPYAREA", "COS(", "COSH(", "CRC(", "CRSCOL", "CRSLIN", "CTIMER", "CURVE", "CVA(", "CVD(", "CVF(", "CVI(", "CVL(", "CVS(", "DATA", "DATE$", "DEC", "DECLOSE$(", "DECRYPT$(", "DEFAULT", "DEFFILL", "DEFFN", "DEFLINE", "DEFMARK", "DEFMOUSE", "DEFTEXT", "DEG(", "DELAY", "DET(", "DEVICE(", "DIM", "DIM?", "DIM?(", "DIR$(", "DIV", "DIV(", "DO", "DOWNTO", "DPEEK(", "DPOKE", "DRAW", "DUMP", "ECHO", "EDIT", "ELLIPSE", "ELSE", "ELSE IF", "ENCLOSE$(", "ENCRYPT$(", "END", "ENDFUNCTION", "ENDIF", "ENDPROCEDURE", "ENDSELECT", "ENV$(", "EOF(", "EQV", "ERASE", "ERR", "ERR$(", "ERROR", "EVAL", "EVAL(", "EVEN(", "EVENT", "EVENT?(", "EVERY", "EXEC", "EXEC(", "EXIST(", "EXIT", "EXIT IF", "EXP(", "EXPM1(", "FACT(", "FALSE", "FATAL", "FFT", "FFT(", "FIB(", "FILEEVENT$", "FILESELECT", "FILL", "FIT", "FIT_LINEAR", "FIT_POLY", "FIX(", "FLOOR(", "FLUSH", "FOR", "FORK(", "FORMINPUT AS", "FORM_ALERT(", "FORM_CENTER(", "FORM_DIAL(", "FORM_DO(", "FRAC(", "FREE", "FREE(", "FREEFILE(", "FSEL_INPUT(", "FSFIRST$(", "FSNEXT$(", "FULLW", "FUNCTION", "GAMMA(", "GASDEV", "GASDEV(", "GCD(", "GET", "GET_COLOR(", "GET_GEOMETRY", "GET_LOCATION", "GET_SCREENSIZE", "GLOB(", "GOLOR_RGB(", "GOSUB", "GOSUBABBREV", "GOTO", "GPRINT", "GPS", "GPS?", "GPS_ALT", "GPS_LAT", "GPS_LON", "GRAPHMODE", "GRAY(", "HASH$(", "HELP", "HEX$(", "HIDEK", "HIDEM", "HOME", "HYPOT(", "IDE", "IF", "IMAG(", "IMP", "INC", "INFOW", "INKEY$", "INLINE$(", "INODE(", "INP(", "INP?(", "INP%(", "INP&(", "INPUT", "INPUT$(", "INSTR(", "INT(", "INV(", "INVERT(", "IOCTL(", "JULDATE$(", "JULIAN(", "KEYEVENT", "KILL", "LCM(", "LEFT$(", "LEFTOF$(", "LEN(", "LET", "LGAMMA(", "LINE", "LINEINPUT", "LINEINPUT$(", "LINK", "LIST", "LISTSELECT(", "LN(", "LOAD", "LOC(", "LOCAL", "LOCATE", "LOF(", "LOG(", "LOG10(", "LOG1P(", "LOGB(", "LOOP", "LOWER$(", "LPEEK(", "LPOKE", "LTEXT", "LTEXTLEN(", "LUCNUM(", "MALLOC(", "MAP", "MAX(", "MENU", "MENUDEF", "MENUKILL", "MENUSET", "MERGE", "MFREE", "MFREE(", "MID$(", "MIN(", "MKA$(", "MKD$(", "MKDIR", "MKF$(", "MKI$(", "MKL$(", "MKS$(", "MOD", "MOD(", "MODE(", "MOTIONEVENT", "MOUSE", "MOUSEEVENT", "MOUSEK", "MOUSES", "MOUSEX", "MOUSEY", "MOVEW", "MSHRINK(", "MSYNC", "MTFD$(", "MTFE$(", "MUL", "MUL(", "NAND", "NEW", "NEXT", "NEXTPRIME(", "NLINK(", "NOOP", "NOP", "NOR", "NOROOTWINDOW", "NOT", "OBJ_DRAW(", "OBJC_ADD", "OBJC_DELETE", "OBJC_DRAW(", "OBJC_FIND(", "OBJC_OFFSET(", "OCT$(", "ODD(", "ON*GOSUB", "ON*GOTO", "ONBREAK", "ONERROR", "ONERRORGOSUB", "OPEN", "OPENW", "OR", "OR(", "OUT", "OUT?(", "PARAM$(", "PAUSE", "PBOX", "PC", "PCIRCLE", "PEEK(", "PELLIPSE", "PI", "PIPE", "PLAYSOUND", "PLAYSOUNDFILE", "PLIST", "PLOT", "PNGDECODE$(", "PNGENCODE$(", "POINT(", "POKE", "POLYFILL", "POLYLINE", "POLYMARK", "POWM(", "PRBOX", "PRED(", "PRG$(", "PRIMORIAL(", "PRINT", "PRINT AT(", "PRINT COLOR(", "PRINT SPC(", "PRINT TAB(", "PRINT TAB( SPC(", "PRINT USING", "PROCEDURE", "PROGRAM", "PTST(", "PUT", "PUT_BITMAP", "PUTBACK", "QUIT", "RAD(", "RADIX$(", "RAND(", "RANDOM(", "RANDOMIZE", "RBOX", "READ", "REAL(", "REALLOC", "REALLOC(", "RECEIVE", "RELSEEK", "REM", "REMABBREV", "RENAME", "REPEAT", "REPLACE$(", "RESTORE", "RESUME", "RETURN", "REVERSE$(", "RIGHT$(", "RIGHTOF$(", "RINSTR(", "RLD$(", "RLE$(", "RMDIR", "RND(", "ROL(", "ROOT(", "ROOTWINDOW", "ROR(", "ROUND(", "ROWS", "RPM", "RSRC_FREE", "RSRC_LOAD", "RUN", "SAVE", "SAVESCREEN", "SAVEWINDOW", "SCOPE", "SCREEN", "SEEK", "SELECT", "SEND", "SENSOR", "SENSOR(", "SENSOR?", "SETENV", "SETFONT", "SETMOUSE", "SGET", "SGN(", "SHELL", "SHL(", "SHM_ATTACH(", "SHM_DETACH", "SHM_FREE", "SHM_MALLOC(", "SHOWK", "SHOWM", "SHOWPAGE", "SHR(", "SIGN$(", "SIN(", "SINH(", "SIZE(", "SIZEW", "SOLVE", "SOLVE(", "SORT", "SOUND", "SP", "SPACE$(", "SPAWN", "SPC(", "SPEAK", "SPLIT", "SPUT", "SQR(", "SQRT(", "SRAND(", "STEP", "STIMER", "STOP", "STR$(", "STRING$(", "SUB", "SUB(", "SUCC(", "SWAP", "SWAP(", "SYM_ADR(", "SYSTEM", "SYSTEM$(", "TAB(", "TALLY(", "TAN(", "TANH(", "TERMINALNAME$", "TERMINALNAME$(", "TEXT", "TIME$", "TIMER", "TITLEW", "TO", "TOPW", "TOUCH", "TRACE", "TRACE$", "TRIM$(", "TROFF", "TRON", "TRUE", "TRUNC(", "TT?", "TYP?(", "UBOUND(", "UCASE$(", "UNCOMPRESS$(", "UNIX", "UNIX?", "UNIXDATE$(", "UNIXTIME$(", "UNLINK", "UNMAP", "UNTIL", "UPPER$(", "USEWINDOW", "USING$(", "VAL(", "VAL?(", "VAR", "VARIAT(", "VARPTR(", "VERSION", "VOID", "ABBREV", "VRFY(", "VSYNC", "VT100", "WATCH", "WAVE", "WEND", "WHILE", "WIN32?", "WORD(", "WORD$(", "WORT_SEP", "WORT_SEP(", "XLOAD", "XOR", "XOR(", "XRUN", "XTRIM$(", "abs(", "absolute", "acos(", "acosh(", "add", "add(", "after", "alert", "and", "and(", "android?", "arg(", "arid$(", "arie$(", "arraycopy", "arrayfill", "arrptr(", "asc(", "asin(", "asinh(", "at(", "atan(", "atan2(", "atanh(", "atn(", "bchg(", "bclr(", "beep", "bell", "bget", "bin$(", "bload", "bmove", "bottomw", "boundary", "box", "bput", "break", "bsave", "bset(", "btst(", "bwtd$(", "bwte$(", "byte(", "call", "call(", "call$(", "calld(", "card(", "case", "cbrt(", "ceil(", "cgi", "chain", "chdir", "chmod", "chr$(", "cint(", "circle", "clear", "clearw", "clip", "close", "closew", "clr", "cls", "color", "color(", "color_rgb(", "cols", "combin(", "compress$(", "conj(", "connect", "cont", "continue", "copy_area", "copyarea", "cos(", "cosh(", "crc(", "crscol", "crslin", "ctimer", "curve", "cva(", "cvd(", "cvf(", "cvi(", "cvl(", "cvs(", "data", "date$", "dec", "declose$(", "decrypt$(", "default", "deffill", "deffn", "defline", "defmark", "defmouse", "deftext", "deg(", "delay", "det(", "device(", "dim", "dim?", "dim?(", "dir$(", "div", "div(", "do", "downto", "dpeek(", "dpoke", "draw", "dump", "echo", "edit", "ellipse", "else", "else if", "enclose$(", "encrypt$(", "end", "endfunction", "endif", "endprocedure", "endselect", "env$(", "eof(", "eqv", "erase", "err", "err$(", "error", "eval", "eval(", "even(", "event", "event?(", "every", "exec", "exec(", "exist(", "exit", "exit if", "exp(", "expm1(", "fact(", "false", "fatal", "fft", "fft(", "fib(", "fileevent$", "fileselect", "fill", "fit", "fit_linear", "fit_poly", "fix(", "floor(", "flush", "for", "fork(", "forminput as", "form_alert(", "form_center(", "form_dial(", "form_do(", "frac(", "free", "free(", "freefile(", "fsel_input(", "fsfirst$(", "fsnext$(", "fullw", "function", "gamma(", "gasdev", "gasdev(", "gcd(", "get", "get_color(", "get_geometry", "get_location", "get_screensize", "glob(", "golor_rgb(", "gosub", "gosubabbrev", "goto", "gprint", "gps", "gps?", "gps_alt", "gps_lat", "gps_lon", "graphmode", "gray(", "hash$(", "help", "hex$(", "hidek", "hidem", "home", "hypot(", "ide", "if", "imag(", "imp", "inc", "infow", "inkey$", "inline$(", "inode(", "inp(", "inp?(", "inp%(", "inp&(", "input", "input$(", "instr(", "int(", "inv(", "invert(", "ioctl(", "juldate$(", "julian(", "keyevent", "kill", "lcm(", "left$(", "leftof$(", "len(", "let", "lgamma(", "line", "lineinput", "lineinput$(", "link", "list", "listselect(", "ln(", "load", "loc(", "local", "locate", "lof(", "log(", "log10(", "log1p(", "logb(", "loop", "lower$(", "lpeek(", "lpoke", "ltext", "ltextlen(", "lucnum(", "malloc(", "map", "max(", "menu", "menudef", "menukill", "menuset", "merge", "mfree", "mfree(", "mid$(", "min(", "mka$(", "mkd$(", "mkdir", "mkf$(", "mki$(", "mkl$(", "mks$(", "mod", "mod(", "mode(", "motionevent", "mouse", "mouseevent", "mousek", "mouses", "mousex", "mousey", "movew", "mshrink(", "msync", "mtfd$(", "mtfe$(", "mul", "mul(", "nand", "new", "next", "nextprime(", "nlink(", "noop", "nop", "nor", "norootwindow", "not", "obj_draw(", "objc_add", "objc_delete", "objc_draw(", "objc_find(", "objc_offset(", "oct$(", "odd(", "on*gosub", "on*goto", "onbreak", "onerror", "onerrorgosub", "open", "openw", "or", "or(", "out", "out?(", "param$(", "pause", "pbox", "pc", "pcircle", "peek(", "pellipse", "pi", "pipe", "playsound", "playsoundfile", "plist", "plot", "pngdecode$(", "pngencode$(", "point(", "poke", "polyfill", "polyline", "polymark", "powm(", "prbox", "pred(", "prg$(", "primorial(", "print", "print at(", "print color(", "print spc(", "print tab(", "print tab( spc(", "print using", "procedure", "program", "ptst(", "put", "put_bitmap", "putback", "quit", "rad(", "radix$(", "rand(", "random(", "randomize", "rbox", "read", "real(", "realloc", "realloc(", "receive", "relseek", "rem", "remabbrev", "rename", "repeat", "replace$(", "restore", "resume", "return", "reverse$(", "right$(", "rightof$(", "rinstr(", "rld$(", "rle$(", "rmdir", "rnd(", "rol(", "root(", "rootwindow", "ror(", "round(", "rows", "rpm", "rsrc_free", "rsrc_load", "run", "save", "savescreen", "savewindow", "scope", "screen", "seek", "select", "send", "sensor", "sensor(", "sensor?", "setenv", "setfont", "setmouse", "sget", "sgn(", "shell", "shl(", "shm_attach(", "shm_detach", "shm_free", "shm_malloc(", "showk", "showm", "showpage", "shr(", "sign$(", "sin(", "sinh(", "size(", "sizew", "solve", "solve(", "sort", "sound", "sp", "space$(", "spawn", "spc(", "speak", "split", "sput", "sqr(", "sqrt(", "srand(", "step", "stimer", "stop", "str$(", "string$(", "sub", "sub(", "succ(", "swap", "swap(", "sym_adr(", "system", "system$(", "tab(", "tally(", "tan(", "tanh(", "terminalname$", "terminalname$(", "text", "time$", "timer", "titlew", "to", "topw", "touch", "trace", "trace$", "trim$(", "troff", "tron", "true", "trunc(", "tt?", "typ?(", "ubound(", "ucase$(", "uncompress$(", "unix", "unix?", "unixdate$(", "unixtime$(", "unlink", "unmap", "until", "upper$(", "usewindow", "using$(", "val(", "val?(", "var", "variat(", "varptr(", "version", "void", "abbrev", "vrfy(", "vsync", "vt100", "watch", "wave", "wend", "while", "win32?", "word(", "word$(", "wort_sep", "wort_sep(", "xload", "xor", "xor(", "xrun", "xtrim$(", "(", ")"};
        Integer argb_basic = Color.parseColor("#A52A2A");
        Integer argb_basic_back = Color.parseColor("#FFE797");
        for (String word : words_basic) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_basic),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new BackgroundColorSpan(argb_basic_back),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_comment = {"#", "REM", "!"};
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n",start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (endOfLine != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = start+word.length();
                }
            }
        }

        return spannable;
    }

    public static Spannable colorized_openbabel(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_brown = {"GAFF", "Ghemical", "MMFF94", "MMFF94s", "UFF", "ECFP0", "ECFP10", "ECFP2", "ECFP4", "ECFP6", "ECFP8", "FP2", "FP3", "FP4", "cansmi", "cansmiNS", "formula", "HBA1", "HBA2", "HBD", "InChI", "InChIKey", "logP", "MR", "MW", "nF", "rotors", "s", "smarts", "title", "TPSA", "eem", "eem2015ba", "eem2015bm", "eem2015bn", "eem2015ha", "eem2015hm", "eem2015hn", "fromfile", "gasteiger", "mmff94", "none"};
        Integer argb_brown = Color.parseColor("#A52A2A");
        for (String word : words_brown) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_brown),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_green = {"cd ", "export ", "-f ", "-l ", "-e ", "-z ", "-zin ", "-k ", "-H ", "-Hall ", "-V ", "-L ", "-m ", "-i ", "-o ", "-O ", "acpid ", "adjtimex ", "ar ", "arch ", "arp ", "arping ", "ash ", "awk ", "basename ", "bc ", "blkdiscard ", "blockdev ", "brctl ", "bunzip2 ", "bzcat ", "bzip2 ", "cal ", "cat ", "chgrp ", "chmod ", "chown ", "chroot ", "chvt ", "clear ", "cmp ", "cp ", "cpio ", "cttyhack ", "cut ", "date ", "dc ", "dd ", "deallocvt ", "depmod ", "devmem ", "df ", "diff ", "dirname ", "dmesg ", "dnsdomainname ", "dos2unix ", "du ", "dumpkmap ", "dumpleases ", "echo ", "egrep ", "env ", "expand ", "expr ", "factor ", "fallocate ", "false ", "fatattr ", "fgrep ", "find ", "fold ", "free ", "freeramdisk ", "fsfreeze ", "fstrim ", "ftpget ", "ftpput ", "getopt ", "getty ", "grep ", "groups ", "gunzip ", "gzip ", "halt ", "head ", "hexdump ", "hostid ", "hostname ", "httpd ", "hwclock ", "i2cdetect ", "i2cdump ", "i2cget ", "i2cset ", "id ", "ifconfig ", "ifdown ", "ifup ", "init ", "insmod ", "ionice ", "ip ", "ipcalc ", "ipneigh ", "kill ", "killall ", "klogd ", "last ", "less ", "link ", "linux32 ", "linux64 ", "linuxrc ", "ln ", "loadfont ", "loadkmap ", "logger ", "login ", "logname ", "logread ", "losetup ", "ls ", "lsmod ", "lsscsi ", "lzcat ", "lzma ", "lzop ", "md5sum ", "mdev ", "microcom ", "mkdir ", "mkdosfs ", "mke2fs ", "mkfifo ", "mknod ", "mkpasswd ", "mkswap ", "mktemp ", "modinfo ", "modprobe ", "more ", "mount ", "mt ", "mv ", "nameif ", "nc ", "netstat ", "nl ", "nologin ", "nproc ", "nsenter ", "nslookup ", "nuke ", "od ", "openvt ", "partprobe ", "paste ", "patch ", "pidof ", "ping ", "ping6 ", "pivot_root ", "poweroff ", "printf ", "ps ", "pwd ", "rdate ", "readlink ", "realpath ", "reboot ", "renice ", "reset ", "resume ", "rev ", "rm ", "rmdir ", "rmmod ", "route ", "rpm ", "rpm2cpio ", "run-init ", "run-parts ", "sed ", "seq ", "setkeycodes ", "setpriv ", "setsid ", "sh ", "sha1sum ", "sha256sum ", "sha512sum ", "shred ", "shuf ", "sleep ", "sort ", "ssl_client ", "start-stop-daemon ", "stat ", "strings ", "stty ", "svc ", "svok ", "swapoff ", "swapon ", "switch_root ", "sync ", "sysctl ", "syslogd ", "tac ", "tail ", "tar ", "taskset ", "tee ", "telnet ", "test ", "tftp ", "time ", "timeout ", "top ", "touch ", "tr ", "traceroute ", "traceroute6 ", "true ", "truncate ", "tty ", "ubirename ", "udhcpc ", "udhcpd ", "uevent ", "umount ", "uname ", "uncompress ", "unexpand ", "uniq ", "unix2dos ", "unlink ", "unlzma ", "unshare ", "unxz ", "unzip ", "uptime ", "usleep ", "uudecode ", "uuencode ", "vconfig ", "vi ", "w ", "watch ", "watchdog ", "wc ", "wget ", "which ", "who ", "whoami ", "xargs ", "xxd ", "xz ", "xzcat ", "yes ", "zcat ", "obabel ", "dftb ", "qcxms ", "modes ", "xbbc ", "xbvm ", "plotms ", "stda ", "xtb ", "xtb4stda ", "waveplot ", "chimescalc ", "chemsol ", "mopac ", "mopac-makpol ", "fastchem ", "mopac-param ", "phreeqc ", "transpose ", "cpx ", "dftd4 ", "multicharge ", "numsa-exe ", "s-dftd3 ", "tblite ", "toybox "};
        Integer argb_green = Color.parseColor("#66BB6A");
        for (String word : words_green) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_green),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_cyan = {"addfilename", "AddInIndex", "AddNonPolarH", "AddPolarH", "canonical", "ChangeCell", "DelNonPolarH", "DelPolarH", "energy", "fillUC", "gen2D", "gen3D", "genalias", "highlight", "largest", "minimize", "neutralize", "partialcharge", "readconformer", "s", "smallest", "sort", "split", "unique", "v"};
        Integer argb_cyan = Color.parseColor("#7AD5E1");
        for (String word : words_cyan) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_cyan),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new android.text.style.StyleSpan(Typeface.BOLD),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_blue = {"abinit", "acesin", "acesout", "acr", "adf", "adfband", "adfdftb", "adfout", "alc", "aoforce", "arc", "ascii", "axsf", "bgf", "box", "bs", "c09out", "c3d1", "c3d2", "cac", "caccrt", "cache", "cacint", "can", "car", "castep", "ccc", "cdjson", "cdx", "cht", "cif", "cjson", "ck", "cof", "com", "CONFIG", "CONTCAR", "CONTFF", "copy", "crk2d", "crk3d", "csr", "cssr", "ct", "cub", "cube", "dallog", "dalmol", "dat", "dmol", "dx", "ent", "exyz", "fa", "fasta", "fch", "fchk", "fck", "feat", "fh", "fhiaims", "fix", "fps", "fpt", "fract", "fs", "fsa", "g03", "g09", "g16", "g92", "g94", "g98", "gal", "gam", "gamess", "gamin", "gamout", "gau", "gjc", "gjf", "got", "gpr", "gr96", "gro", "gukin", "gukout", "gzmat", "hin", "HISTORY", "inchi", "inchikey", "inp", "ins", "jin", "jout", "k", "lmpdat", "log", "lpmd", "mcdl", "mcif", "MDFF", "mdl", "ml2", "mmcif", "mmd", "mmod", "mna", "mol", "mol2", "mold", "molden", "molf", "molreport", "moo", "mop", "mopcrt", "mopin", "mopout", "mp", "mpc", "mpd", "mpo", "mpqc", "mpqcin", "msi", "msms", "nul", "nw", "nwo", "orca", "orcainp", "out", "outmol", "output", "paint", "pcjson", "pcm", "pdb", "pdbqt", "png", "pointcloud", "pos", "POSCAR", "POSFF", "pov", "pqr", "pqs", "prep", "pwscf", "qcin", "qcout", "report", "res", "rinchi", "rsmi", "rxn", "sd", "sdf", "siesta", "smi", "smiles", "smy", "stl", "svg", "sy2", "t41", "tdd", "text", "therm", "tmol", "txt", "txyz", "unixyz", "VASP", "vmol", "wln", "xed", "xsf", "xtc", "xyz", "yob", "zin"};
        Integer argb_blue = Color.BLUE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        return spannable;
    }

    public static Spannable colorized_xtb(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_basic = {"polynomial", "logfermi", "auto", "all", "normal", "tight", "verytight", "extreme", "still", "concerted", "sequential", "vf", "lbfgs", "inertial", "crude", "sloppy", "loose", "lax", "normal", "vtight", "acetone", "acetonitrile", "aniline", "benzaldehyde", "benzene", "CH2Cl2", "CHCl3", "CS2", "dioxane", "dmf", "dmso", "ether", "ethylacetate", "furane", "hexadecane", "methanol", "nitromethane", "octanol", "woctanol", "phenol", "toluene", "thf", "water", "H2O", "ei", "xtb2", "xtb1", "xtb0", "ntraj", "tmax", "eimp0", "charge", "upper", "lower", "cid", "elab", "lchamb", "true", "false", "2methylpyridine", "4methyl2pentanone", "aceticacid", "acetophenone", "anisole", "benzylalcohol", "bromobenzene", "bromoethane", "bromoform", "bromooctane", "butanol", "butanone", "butylacetate", "butylbenzene", "carbondisulfide", "carbontet", "chlorobenzene", "chloroform", "chlorohexane", "cyclohexane", "cyclohexanone", "decalin", "decane", "decanol", "dibromoethane", "dibutylether", "dichloroethane", "diethylether", "diisopropylether", "dimethylacetamide", "dimethylformamide", "dimethylpyridine", "dimethylsulfoxide", "dodecane", "ethanol", "ethoxybenzene", "ethylbenzene", "fluorobenzene", "fluoroctane", "heptane", "hexadecyliodide", "hexane", "hexanol", "iodobenzene", "isobutanol", "isooctane", "isopropanol", "isopropylbenzene", "isopropyltoluene", "mcresol", "mesitylene", "methoxyethanol", "methylenechloride", "methylformamide", "nitrobenzene", "nitroethane", "nonane", "nonanol", "octane", "odichlorobenzene", "onitrotoluene", "pentadecane", "pentane", "pentanol", "perfluorobenzene", "phenylether", "propanol", "pyridine", "secbutanol", "secbutylbenzene", "tbutylbenzene", "tetrachloroethene", "tetrahydrofuran", "tetrahydrothiophenedioxide", "tetralin", "tributylphosphate", "triethylamine", "trimethylbenzene", "undecane"};
        Integer argb_basic = Color.parseColor("#A52A2A");
        Integer argb_basic_back = Color.parseColor("#FFE797");
        for (String word : words_basic) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_basic),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new BackgroundColorSpan(argb_basic_back),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        String[] words_brown = {"bar1M", "xcontrol", "reference", "nb", "bpair", "alist", "blist", "tlist", "vtors", "vbond", "vangl", "sccacc", "step", "isotope", "modify mass", "scale mass", "element mass", "sthr", "rmsd", "dump", "hmass", "nvt", "restart", "temp", "time", "shake", "velo", "save", "kpush", "alp", "coord", "inner logs", "derived k", "attractive", "silent", "nrun", "npoint", "anopt", "kpull", "ppull", "input", "pocket", "maxparent", "atm", "atoms", "elements", "force constant", "distance", "angle", "dihedral", "torsions", "potential", "sphere", "ellipsoid", "alpha", "beta", "temp", "autoscale", "axisshift", "output file", "json", "engine", "gbsa", "gbsagrid", "kernel", "maxcycle", "mode"};
        Integer argb_brown = Color.parseColor("#A52A2A");
        for (String word : words_brown) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_brown),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_cyan = {"dock", "topo", "info", "thermo", "ir"};
        Integer argb_cyan = Color.parseColor("#7AD5E1");
        for (String word : words_cyan) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_cyan),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                spannable.setSpan(
                        new android.text.style.StyleSpan(Typeface.BOLD),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_green = {"--ceh ", "--tblite ", "--ptb ", "--cosmo ", "--tmcosmo ", "--cpcmx ", "--raman ", "--alpha ", "--json ", "cd ", "export ", "-j ", "-t ", "-c ", "-check ", "-p ", "-prod ", "-eonly ", "-e0 ", "-e1 ", "-qcp ", "-qcpath ", "-unity ", "-v ", "-verbose ", "-f ", "-file ", "-w ", "--width ", "--s ", "--cascades ", "-m ", "--min ", "-i ", "--mzmin ", "-p ", "--noisotope ", "-e ", "--exp ", "--iterations ", "--cycles ", "--bhess ", "--oniom ", "--cut ", "--ceasefiles ", "--wrtopo ", "--sp ", "--pocket ", "--nostack ", "--noangular ", "--fast ", "--atm ", "--stepr ", "--stepa ", "--maxgen ", "--maxparent ", "--nstack ", "--nfinal ", "--ensemble ", "--etemp ", "--iterations ", "-a ", "--acc ", "--opt ", "--gfn2 ", "--gfn1 ", "--gfnff ", "--help", "--version", "--uhf ", "-- ", "--gfn ", "--restart ", "--ohess ", "--hess ", "--scc ", "--grad ", "--vip ", "--vipea ", "--vomega ", "--vfukui ", "--esp ", "--stm ", "--metaopt ", "--path ", "--modef ", "--omd ", "--md ", "--metadyn ", "--siman ", "-c ", "--chrg ", "-u ", "--vparam ", "-alpb ", "--alpb ", "-g ", "-gbsa ", "--gbsa ", "--cma ", "--pop ", "--molden ", "--dipole ", "--wbo ", "--lmo ", "--fod ", "-I ", "--input ", "--namespace ", "--copy ", "--nocopy ", "--norestart ", "-p ", "--parallel ", "--define ", "--citation ", "--charge ", "--license", "-v ", "--verbose ", "-s ", "--silent ", "--strict ", "-h ", "--sthr ", "--temp ", "--turbomole ", "--orca ", "--dftb+ ", "--dftbplus ", "--born ", "-f ", "-chk ", "-ax ", "-e ", "-p ", "-lpt ", "-al ", "-be ", "-t ", "-rpa ", "-vectm ", "-xtb ", "-oldtda ", "-resp ", "-aresp ", "-optrot ", "-2PA ", "-s2s ", "-sf ", "-nto ", "-rw ", "-dual ", "acpid ", "adjtimex ", "ar ", "arch ", "arp ", "arping ", "ash ", "awk ", "basename ", "bc ", "blkdiscard ", "blockdev ", "brctl ", "bunzip2 ", "bzcat ", "bzip2 ", "cal ", "cat ", "chgrp ", "chmod ", "chown ", "chroot ", "chvt ", "clear ", "cmp ", "cp ", "cpio ", "cttyhack ", "cut ", "date ", "dc ", "dd ", "deallocvt ", "depmod ", "devmem ", "df ", "diff ", "dirname ", "dmesg ", "dnsdomainname ", "dos2unix ", "du ", "dumpkmap ", "dumpleases ", "echo ", "egrep ", "env ", "expand ", "expr ", "factor ", "fallocate ", "false ", "fatattr ", "fgrep ", "find ", "fold ", "free ", "freeramdisk ", "fsfreeze ", "fstrim ", "ftpget ", "ftpput ", "getopt ", "getty ", "grep ", "groups ", "gunzip ", "gzip ", "halt ", "head ", "hexdump ", "hostid ", "hostname ", "httpd ", "hwclock ", "i2cdetect ", "i2cdump ", "i2cget ", "i2cset ", "id ", "ifconfig ", "ifdown ", "ifup ", "init ", "insmod ", "ionice ", "ip ", "ipcalc ", "ipneigh ", "kill ", "killall ", "klogd ", "last ", "less ", "link ", "linux32 ", "linux64 ", "linuxrc ", "ln ", "loadfont ", "loadkmap ", "logger ", "login ", "logname ", "logread ", "losetup ", "ls ", "lsmod ", "lsscsi ", "lzcat ", "lzma ", "lzop ", "md5sum ", "mdev ", "microcom ", "mkdir ", "mkdosfs ", "mke2fs ", "mkfifo ", "mknod ", "mkpasswd ", "mkswap ", "mktemp ", "modinfo ", "modprobe ", "more ", "mount ", "mt ", "mv ", "nameif ", "nc ", "netstat ", "nl ", "nologin ", "nproc ", "nsenter ", "nslookup ", "nuke ", "od ", "openvt ", "partprobe ", "paste ", "patch ", "pidof ", "ping ", "ping6 ", "pivot_root ", "poweroff ", "printf ", "ps ", "pwd ", "rdate ", "readlink ", "realpath ", "reboot ", "renice ", "reset ", "resume ", "rev ", "rm ", "rmdir ", "rmmod ", "route ", "rpm ", "rpm2cpio ", "run-init ", "run-parts ", "sed ", "seq ", "setkeycodes ", "setpriv ", "setsid ", "sh ", "sha1sum ", "sha256sum ", "sha512sum ", "shred ", "shuf ", "sleep ", "sort ", "ssl_client ", "start-stop-daemon ", "stat ", "strings ", "stty ", "svc ", "svok ", "swapoff ", "swapon ", "switch_root ", "sync ", "sysctl ", "syslogd ", "tac ", "tail ", "tar ", "taskset ", "tee ", "telnet ", "test ", "tftp ", "time ", "timeout ", "top ", "touch ", "tr ", "traceroute ", "traceroute6 ", "true ", "truncate ", "tty ", "ubirename ", "udhcpc ", "udhcpd ", "uevent ", "umount ", "uname ", "uncompress ", "unexpand ", "uniq ", "unix2dos ", "unlink ", "unlzma ", "unshare ", "unxz ", "unzip ", "uptime ", "usleep ", "uudecode ", "uuencode ", "vconfig ", "vi ", "w ", "watch ", "watchdog ", "wc ", "wget ", "which ", "who ", "whoami ", "xargs ", "xxd ", "xz ", "xzcat ", "yes ", "zcat ", "obabel ", "dftb ", "qcxms ", "modes ", "xbbc ", "xbvm ", "plotms ", "stda ", "xtb ", "xtb4stda ", "waveplot ", "chimescalc ", "chemsol ", "mopac ", "mopac-makpol ", "fastchem ", "mopac-param ", "phreeqc ", "transpose ", "cpx ", "dftd4 ", "multicharge ", "numsa-exe ", "s-dftd3 ", "tblite ", "toybox "};
        Integer argb_green = Color.parseColor("#66BB6A");
        for (String word : words_green) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_green),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_gray = {".CHRG", ".UHF"};
        Integer argb_gray = Color.DKGRAY;
        for (String word : words_gray) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_gray),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_blue = {"$coord", "$end", "$periodic", "$cell", "$coord frac", "$lattice", "$lattice bohr", "$fix", "$constrain", "$write", "$wall", "$cmd", "$date", "$chrg", "$spin", "$pairpar", "$opt", "$scan", "$gbsa", "$thermo", "$hess", "$metadyn", "$md", "$external", "$oniom", "$path", "$embedding", "$dock", "$directed"};
        Integer argb_blue = Color.BLUE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_comment = {"#", "!"};
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n",start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (endOfLine != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = start+word.length();
                }
            }
        }

        return spannable;
    }

    public static Spannable colorized_dftb(final String text) {
        SpannableString spannable = new SpannableString(text);
        Integer argb_back = Color.WHITE;

        String[] words_gray = {"ARPACK.DAT", "atomenergies.dat", "band.out", "born.out", "bornderiv.out", "charges.bin", "COEF.DAT", "dE_band.out", "detailed.out", "eigenvec.bin", "eigenvec.out", "energyvst.dat", "ESP.dat", "EXC.DAT", "hamreal.dat", "hamsqr.dat", "hessian.out", "laser.dat", "localOrbs.bin", "localOrbs.out", "md.out", "mu.dat", "NACV.DAT", "overreal.dat", "oversqr.dat", "ppRPA_ener.DAT", "qsvst.dat", "relaxed_charge.dat", "results.tag", "SPX.DAT", "tdp-reks.dat", "TDP.DAT", "TEST_ARPACK.DAT", "TRA.DAT", "XCH.DAT", "XplusY.DAT", "XREST.DAT"};
        Integer argb_gray = Color.DKGRAY;
        for (String word : words_gray) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_gray),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_brown = {"a1", "a2", "AdaptFillingTemp", "AllAtomCharges", "AllAtomSpins", "ALPB", "Alpha", "alpha", "Analysis", "AngularGrid", "AngularMomentum", "Animate", "aPar", "AppendFile", "AppendGeometries", "Arpack", "AtomCharge", "AtomDensityCuto", "AtomDensityTolerance", "AtomicNumber", "AtomicNumbers", "AtomRange", "AtomResolvedEnergies", "Atoms", "AtomSitePotential", "AtomSpin", "Autotune", "Barostat", "Basis", "Beta", "BinaryAccessTypes", "Blacs", "BornCharges", "BornDerivs", "BornOset", "BornScale", "Boundary Conditions", "BoundaryRegion", "Box", "BoxExtension", "BuerLength", "BuildBulkPotential", "CacheCharges", "CalculateForces", "Casida", "CGmaxIter", "ChainLength", "Charge", "ChargeDensity", "ChargeModel", "ChargeScale", "ChargeSteepness", "Chi", "Chimes", "Choleskii", "Circle", "CM5", "Coecients", "computeLDOS", "Conductance{", "Constant{", "Constraints", "Contact", "Contact{", "ContactHamiltonian", "ContactId", "ContactSeparation", "ContactTemperature", "ContactVector", "ContourPoints", "ConvergedPerturb", "Convergence", "ConvergentSccOnly", "CoordinationNumber", "CoordsAndCharges", "Coupling", "CouplingStrength", "CovalentRadius", "CustomisedHubbards", "CustomisedOccupations", "CutCN", "Cuto", "CutoCheck", "CutoCN", "CutoInter", "CutoReduction", "CutoThree", "Cylindrical", "Damping", "Delta", "DeltaModel", "Dense", "Density", "Descreening", "DetailedXML", "Device", "Device{", "DFTB+U", "DFTB3", "DiagLimit", "Diagonaliser", "DiagonalRescaling", "Dierentiation", "Direction", "Directions", "DirectRead{", "DispElem", "Dispersion", "DisplayModes", "DispNorm", "DomainDecomposition", "Driver", "DynMixingParameters", "EigenvecBin", "EigenvectorsAsText", "ElectricField", "ElectronDynamics", "Electronegativities", "ElectrostaticPotential", "Electrostatics", "ELPA", "EnclosedPoles", "Energy", "EnergyRange", "EnergyStep", "EnergyWindow", "EnvelopeShape", "EnvelopeShape{", "Epsilon", "EulerFrequency", "EwaldParameter", "EwaldTolerance", "ExcitedAtoms", "ExcitedState", "ExcitedStateForces", "Exponents", "External", "fAlpha", "fDec", "FermiCuto", "FermiLevel", "FieldStrength", "File", "FillBoxWithAtoms", "Filling", "FillingsFromFile", "fInc", "FIRE{", "FirstLayerAtoms", "FixAngles", "FixedFermiLevel", "FixLengths", "FoldAtomsToUnitCell", "FonMaxIter", "ForceEvaluation", "Forces", "FreeEnergyShift", "FreqRange", "FreqStep", "Frequencies", "Frequency", "FrequencyRange", "Functional", "g{", "Gam", "Gate", "GateDistance", "GateLenth_l", "GateLenth_t", "GatePotential", "GateRadius", "Gaussian{", "GaussianBlurWidth", "GeneralisedBorn{", "Generations", "Geometry", "Global", "Gpu", "GradElem", "Gradient", "GradNorm", "GreensFunction", "GreensFunction{", "Grid", "GridPoints", "Gross", "GroundGuess", "GroundState", "Groups", "H5Scaling", "HalogenXCorr", "Hamiltonian", "HardCutO", "HBondCorr", "HBondStrength", "HCorrection", "HelicalSampled{", "HelicalUniform{", "Hessian", "HHRepulsion", "HHubbard", "Host", "HubbardDerivs", "HybridDependentPol{", "HybridPolarisations", "HybridPolarization", "i-PI{", "Id", "IgnoreUnprocessedNodes", "ImagComponent", "ImagPolarisationDirection", "IncludeAllStates", "IndependentKFilling", "InitialCharges", "InitialSpins", "InitialTemperature", "InitMixingParameter", "InputVersion", "IntegrationSteps", "IntegratorSteps", "InverseJacobiWeight", "IonDynamics", "Isotropic", "Kcn", "KeepStationary", "Kernel", "KGrid", "KGridShift", "Kick{", "KickAndLaser{", "KickPolDir", "KPointsAndWeights", "Label", "Laser{", "LaserEnergy", "LaserImagPolDir", "LaserPolDir", "LaserStrength", "LatticeOptLatticeVectors", "LBFGS{", "LevelSpacing", "LineSearch", "LocalCurrents", "Localise", "LowerCaseTypeName", "LowestEnergy", "Mass", "Masses", "Masses{", "MassPerAtom", "Matrix", "MaxAngularMomentum", "MaxAtomStep", "MaxForceComponent", "MaximalForceComponent", "MaximalWeight", "MaxIterations", "MaxLatticeStep", "MaxParallelNodes", "MaxPerturbIter", "MaxPoissonIterations", "MaxSCCIterations", "MaxSccIterations", "MaxSKCuto", "MaxSteps", "MDRestartFrequency", "Memory", "Method", "MinEdgeLength", "MinimalGrid", "MinimalWeight", "MinimiseMemoryUsage", "MinSccIterations", "Mixer", "MixingParameter", "Mode", "MolecularMass", "Monkhorst-Pack scheme", "MovedAtoms", "MullikenAnalysis", "muPoints", "Net", "nInterationsELPA", "nMin", "NOmegaGrid", "NonAdiabaticCoupling", "NonAufbau{", "NPHensemble", "NPTensemble", "NrOfCachedGrids", "NrOfExcitations", "NrOfPoints", "NrOfVirtualStates", "NTPoly", "NumericalNorm", "NVEensemble", "NVTensemble", "OBCCorrection", "Occupation", "Oset", "OldSKInterpolation", "OMM", "OnSiteCorrection", "Optimiser", "Options", "Orbital", "OrbitalPotential", "OrbitalResolved", "Order", "Origin", "OscillatorWindow", "OutputFile", "OutputPrex", "OverrideBulkBC", "OverrideDefaultBC", "Parallel", "Parallelisations", "ParameterFile", "ParamFile", "ParserOptions", "ParserVersion", "Periodic", "Perturbation", "Perturbation{", "PerturbDegenTol", "PerturbEta", "PerturbSccTol", "PEXSI", "Phase", "PhononDispersion", "PipekMezey", "Planar", "PlotModes", "PlottedKPoints", "PlottedLevels", "PlottedRegion", "PlottedSpins", "PLShiftTolerance", "Plumed", "PointCharges", "Points", "Poisson{", "PoissonAccuracy", "PoissonBox", "PoissonThickness", "Polarisability", "PolarisationDirection", "Poles", "PolynomialRepulsive", "Populations", "Port", "Potential", "PP-RPA", "Preconditioner", "Prex", "Pressure", "PreSteps", "Probe", "ProbeProbeRange", "ProbeRadius", "ProcsPerPole", "ProjectStates", "Protocol", "Pump", "PumpProbeFrames", "PuricationMethod", "Rad", "Radii", "RadiiScaling", "RandomSeed", "RangeSeparated", "RangeSeparated=None", "RangeSeparation", "ReadBinaryContact", "ReadChargesAsText", "ReadEigenvectors", "ReadInitialCharges", "ReadOldBulkPotential", "ReadSurfaceGFs", "RealAxisPoints", "RealAxisStep", "RealComponent", "RecomputeAfterDensity", "ReferenceSet", "Region", "REKS", "Reks", "RelaxedDensity", "RelaxTotalSpin", "RemoveRotation", "RemoveTranslation", "RepeatBox", "repeatgen", "RescaleSolvatedFields", "ReselectIndividually", "ReselectProbability", "Resolution", "ResponseKernel", "Restart", "RestartFrequency", "RestartFromAscii", "RPA", "RScaling", "s10", "s6", "s8", "s9", "SASA", "SaveMemory", "SavePotential", "SaveSurfaceGFs", "Scale", "ScalingFactor", "SCC", "SCCTolerance", "SccTolerance", "Screening", "sec:Damp X-H", "sec:DFTB3-D3H5", "SelectedShells", "Separator", "ShellResolved", "ShellResolvedSCC", "ShellResolvedSpin", "Shift", "ShiftGrid", "ShowFoldedCoords", "Sin2{", "SkipChargeTest", "SKMaxDistance", "SlaterKosterFiles", "Smoothing", "Softening", "Solvation", "Solvent", "Solver", "Spacing", "Sparse", "SparseTolerances", "SpeciedPLs", "SpectralRadius", "SpinConstants", "SpinOrbit", "SpinPerAtom", "SpinPolarisation", "SpinPurify", "SpinTuning", "SpinType", "Square", "SSR22", "State", "state resolved Mulliken population", "StateCouplings", "StateInteractions", "StateOfInterest", "Static", "Steps", "StepSize", "stop_driver", "stop_scc", "StopAfterParsing", "Stratmann", "Strength", "SubSpaceFactor", "Sux", "SurfaceTension", "SymbolicFactorProcs", "Symmetry", "TammDanco", "TargetMicrostate", "TargetState", "Task", "Task = ContactHamiltonian{", "Task = UploadContacts", "Task = UploadContacts{", "Temperature", "TemperatureProle{", "TempRange", "TempStep", "TerminalCurrents", "TestArnoldi", "Thermostat", "ThirdOrder", "ThirdOrderFull", "Threebody", "Threshold", "Time0", "Time1", "Timescale", "TimeStep", "TimingVerbosity", "Tolerance", "TotalAtomicDensity", "TotalChargeDensity", "TotalChargeDierence", "TotalSpinPolarisation", "TotalSpinPolarization", "TotalStateCoes", "TransientSteps", "TransitionDipole", "Transport", "Transport{", "TransportOnly", "TruncateSKRange", "Truncation", "TunnelingAndDos", "TunnelingAndDOS{", "TypeNames", "TypesAndCoordinates", "UnpairedElectrons", "UploadContacts", "UseFromStart", "UseOmpThreads", "v{", "VacuumAxis", "vanDerWaalsRadiiD3", "Velocities", "Verbose", "Verbosity", "VerbosityLevel", "Vext", "WeightFactor", "WeightingFactor", "WideBand", "WriteAsciiRestart", "WriteAtomicEnergies", "WriteAutotestTag", "WriteBandOut", "WriteBinaryContact", "WriteBondEnergy", "WriteBondPopulation", "WriteCharges", "WriteChargesAsText", "WriteCoecients", "WriteCosmoFile", "WriteDensityMatrix", "WriteDetailedOut", "WriteDetailedXML", "WriteEigenvectors", "WriteEnergyAndCharges", "WriteFrequency", "WriteHS", "WriteHSDInput", "WriteLDOS", "WriteMulliken", "WriteNetCharges", "WriteRealHS", "WriteRestart", "WriteResultsTag", "WriteSPTransitions", "WriteStatusArnoldi", "WriteTransitionCharges", "WriteTransitionDipole", "WriteTransitions", "WriteTunn", "WriteXplusY", "WScaling", "x{", "Xlbomd", "XlbomdFast", "{", "}"};
        Integer argb_brown = Color.parseColor("#A52A2A");
        for (String word : words_brown) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_brown),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_green = {"cd ", "export ", "acpid ", "adjtimex ", "ar ", "arch ", "arp ", "arping ", "ash ", "awk ", "basename ", "bc ", "blkdiscard ", "blockdev ", "brctl ", "bunzip2 ", "bzcat ", "bzip2 ", "cal ", "cat ", "chgrp ", "chmod ", "chown ", "chroot ", "chvt ", "clear ", "cmp ", "cp ", "cpio ", "cttyhack ", "cut ", "date ", "dc ", "dd ", "deallocvt ", "depmod ", "devmem ", "df ", "diff ", "dirname ", "dmesg ", "dnsdomainname ", "dos2unix ", "du ", "dumpkmap ", "dumpleases ", "echo ", "egrep ", "env ", "expand ", "expr ", "factor ", "fallocate ", "false ", "fatattr ", "fgrep ", "find ", "fold ", "free ", "freeramdisk ", "fsfreeze ", "fstrim ", "ftpget ", "ftpput ", "getopt ", "getty ", "grep ", "groups ", "gunzip ", "gzip ", "halt ", "head ", "hexdump ", "hostid ", "hostname ", "httpd ", "hwclock ", "i2cdetect ", "i2cdump ", "i2cget ", "i2cset ", "id ", "ifconfig ", "ifdown ", "ifup ", "init ", "insmod ", "ionice ", "ip ", "ipcalc ", "ipneigh ", "kill ", "killall ", "klogd ", "last ", "less ", "link ", "linux32 ", "linux64 ", "linuxrc ", "ln ", "loadfont ", "loadkmap ", "logger ", "login ", "logname ", "logread ", "losetup ", "ls ", "lsmod ", "lsscsi ", "lzcat ", "lzma ", "lzop ", "md5sum ", "mdev ", "microcom ", "mkdir ", "mkdosfs ", "mke2fs ", "mkfifo ", "mknod ", "mkpasswd ", "mkswap ", "mktemp ", "modinfo ", "modprobe ", "more ", "mount ", "mt ", "mv ", "nameif ", "nc ", "netstat ", "nl ", "nologin ", "nproc ", "nsenter ", "nslookup ", "nuke ", "od ", "openvt ", "partprobe ", "paste ", "patch ", "pidof ", "ping ", "ping6 ", "pivot_root ", "poweroff ", "printf ", "ps ", "pwd ", "rdate ", "readlink ", "realpath ", "reboot ", "renice ", "reset ", "resume ", "rev ", "rm ", "rmdir ", "rmmod ", "route ", "rpm ", "rpm2cpio ", "run-init ", "run-parts ", "sed ", "seq ", "setkeycodes ", "setpriv ", "setsid ", "sh ", "sha1sum ", "sha256sum ", "sha512sum ", "shred ", "shuf ", "sleep ", "sort ", "ssl_client ", "start-stop-daemon ", "stat ", "strings ", "stty ", "svc ", "svok ", "swapoff ", "swapon ", "switch_root ", "sync ", "sysctl ", "syslogd ", "tac ", "tail ", "tar ", "taskset ", "tee ", "telnet ", "test ", "tftp ", "time ", "timeout ", "top ", "touch ", "tr ", "traceroute ", "traceroute6 ", "true ", "truncate ", "tty ", "ubirename ", "udhcpc ", "udhcpd ", "uevent ", "umount ", "uname ", "uncompress ", "unexpand ", "uniq ", "unix2dos ", "unlink ", "unlzma ", "unshare ", "unxz ", "unzip ", "uptime ", "usleep ", "uudecode ", "uuencode ", "vconfig ", "vi ", "w ", "watch ", "watchdog ", "wc ", "wget ", "which ", "who ", "whoami ", "xargs ", "xxd ", "xz ", "xzcat ", "yes ", "zcat ", "obabel ", "dftb ", "qcxms ", "modes ", "xbbc ", "xbvm ", "plotms ", "stda ", "xtb ", "xtb4stda ", "waveplot ", "chimescalc ", "chemsol ", "mopac ", "mopac-makpol ", "fastchem ", "mopac-param ", "phreeqc ", "transpose ", "cpx ", "dftd4 ", "multicharge ", "numsa-exe ", "s-dftd3 ", "tblite ", "toybox "};
        Integer argb_green = Color.parseColor("#66BB6A");
        for (String word : words_green) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_green),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_blue = {"Geometry", "Hamiltonian", "Driver", "Options", "Analysis", "ExcitedState", "ElectronDynamics", "REKS", "InputVersion", "ParserOptions", "Parallel", "Periodic", "LatticeVectors", "TypeNames", "TypesAndCoordinates", "Periodic", "GenFormat", "xyzFormat", "VaspFormat", "GeometryOptimisation", "Socket", "SteepestDescent", "ConjugateGradient", "gDIIS", "LBFGS", "FIRE", "SecondDerivatives", "VelocityVerlet", "Optimiser", "MovedAtoms", "LatticeOpt", "FixAngles", "FixLengths", "Isotropic", "Convergence", "MaxSteps", "OutputPrefix", "AppendGeometries", "Rational", "DiagLimit", "Memory", "nMin", "aPar", "fInc", "fDec", "fAlpha", "StepSize", "Animate", "Atoms", "DisplayModes", "GenFormat", "Geometry", "Hessian", "LatticeVectors", "LowerCaseTypeName", "Periodic", "PlotModes", "Prefix", "Separator", "SlaterKosterFiles", "Suffix", "Type2FileNames", "TypeNames", "TypesAndCoordinates", "XMakeMol"};
        Integer argb_blue = Color.BLUE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
//                spannable.setSpan(
//                        new BackgroundColorSpan(argb_back),start,start+word.length(),
//                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                );
                substringStart = start+word.length();
            }
        }

        String[] words_comment = {"#", "!"};
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n",start);
                // endOfLine = -1 in the last line, since there is no more line break until the ond of the file
                if (endOfLine != -1) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,endOfLine,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(
                            // in the last line, only the "#" character would be colorized by green, the following characters would be either black or colorized by previous
//                            new ForegroundColorSpan(argb_comment), start, start+word.length(),
                            // text.length() is the position of the end of whole text, better (it works as should)
                            new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
//                    spannable.setSpan(
//                            new BackgroundColorSpan(argb_back),start,text.length(),
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                    );
                    substringStart = start+word.length();
                }
            }
        }

        return spannable;
    }

}
