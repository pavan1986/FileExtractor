import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formattable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class FilesExtractor {
	public static final String SEO_TEXT = "<!-- SEOTEXT -->";
	public static final int SEO_TEXT_LENGTH = SEO_TEXT.length();
	public static final String TABLE_END = "</table></div>";
	public static final int TABLE_END_LENGTH = TABLE_END.length();

	public static final String ROW_END = "</td>";

	public static final String COMPANY_NAME_SEARCH_TXT = "company_name</th><td>";
	public static final int COMPANY_NAME_SEARCH_TXT_LEN = COMPANY_NAME_SEARCH_TXT
			.length();

	public static final String HEADING = "<div style=\"display:none\"><h1>";
	public static final Integer HEADING_LENGTH = HEADING.length();
	public static final String HEADING_END = "</h1><table>";

	public static final String part_time_eligible = "part_time_eligible</th><td>";
	public static final Integer part_time_eligible_len = part_time_eligible
			.length();

	public static final String intranet_forms = "intranet_forms</th><td>";
	public static final Integer intranet_forms_len = intranet_forms.length();

	public static final String data_provider_name = "data_provider_name</th><td>";
	public static final Integer data_provider_name_len = data_provider_name
			.length();

	public static final String slug = "slug</th><td>";
	public static final Integer slug_len = slug.length();

	public static final String matching_gift_offered = "matching_gift_offered</th><td>";
	public static final Integer matching_gift_offered_len = matching_gift_offered
			.length();

	public static final String corporate_contact_email = "corporate_contact_email</th><td>";
	public static final Integer corporate_contact_email_len = corporate_contact_email
			.length();

	public static final String higher_ed = "higher_ed</th><td>";
	public static final Integer higher_ed_len = higher_ed.length();

	public static final String minimum_matched = "minimum_matched</th><td>";
	public static final Integer minimum_matched_len = minimum_matched.length();

	public static final String k12 = "k12</th><td>";
	public static final Integer k12_len = k12.length();

	public static final String volunteer_minimum_hours_required = "volunteer_minimum_hours_required</th><td>";
	public static final Integer volunteer_minimum_hours_required_len = volunteer_minimum_hours_required
			.length();

	public static final String intranet_guidelines = "intranet_guidelines</th><td>";
	public static final Integer intranet_guidelines_len = intranet_guidelines
			.length();

	public static final String arts_and_cultural = "arts_and_cultural</th><td>";
	public static final Integer arts_and_cultural_len = arts_and_cultural
			.length();

	public static final String corporate_contact_name = "corporate_contact_name</th><td>";
	public static final Integer corporate_contact_name_len = corporate_contact_name
			.length();

	public static final String corporate_donation_offered = "corporate_donation_offered</th><td>";
	public static final Integer corporate_donation_offered_len = corporate_donation_offered
			.length();

	public static final String email_domains = "email_domains</th><td>";
	public static final Integer email_domains_len = email_domains.length();

	public static final String all_nonprofits = "all_nonprofits</th><td>";
	public static final Integer all_nonprofits_len = all_nonprofits.length();

	public static final String matching_gift_process = "matching_gift_process</th><td>";
	public static final Integer matching_gift_process_len = matching_gift_process
			.length();

	public static final String company_name = "company_name</th><td>";
	public static final Integer company_name_len = company_name.length();

	public static final String flag_comment = "flag_comment</th><td>";
	public static final Integer flag_comment_len = flag_comment.length();

	public static final String corporate_contact_phone = "corporate_contact_phone</th><td>";
	public static final Integer corporate_contact_phone_len = corporate_contact_phone
			.length();

	public static final String full_time_eligible = "full_time_eligible</th><td>";
	public static final Integer full_time_eligible_len = full_time_eligible
			.length();

	public static final String region = "region</th><td>";
	public static final Integer region_len = region.length();

	public static final String updated_at = "updated_at</th><td>";
	public static final Integer updated_at_len = updated_at.length();

	public static final String url_guidelines = "url_guidelines</th><td>";
	public static final Integer url_guidelines_len = url_guidelines.length();

	public static final String url_forms = "url_forms</th><td>";
	public static final Integer url_forms_len = url_forms.length();

	public static final String retirees_eligible = "retirees_eligible</th><td>";
	public static final Integer retirees_eligible_len = retirees_eligible
			.length();

	public static final String status = "status</th><td>";
	public static final Integer status_len = status.length();

	public static final String ratio = "ratio</th><td>";
	public static final Integer ratio_len = ratio.length();

	public static final String id = "id</th><td>";
	public static final Integer id_len = id.length();

	public static final String subsidiaries = "subsidiaries</th><td>";
	public static final Integer subsidiaries_len = subsidiaries.length();

	public static final String environmental = "environmental</th><td>";
	public static final Integer environmental_len = environmental.length();

	public static final String data_provider_email = "data_provider_email</th><td>";
	public static final Integer data_provider_email_len = data_provider_email
			.length();

	public static final String maximum_matched = "maximum_matched</th><td>";
	public static final Integer maximum_matched_len = maximum_matched.length();

	public static final String civic_community = "civic_community</th><td>";
	public static final Integer civic_community_len = civic_community.length();

	public static final String volunteer_grant_process = "volunteer_grant_process</th><td>";
	public static final Integer volunteer_grant_process_len = volunteer_grant_process
			.length();

	public static final String instructions = "instructions</th><td>";
	public static final Integer instructions_len = instructions.length();

	public static final String volunteer_grant_offered = "volunteer_grant_offered</th><td>";
	public static final Integer volunteer_grant_offered_len = volunteer_grant_offered
			.length();

	public static final String health_human_services = "health_human_services</th><td>";
	public static final Integer health_human_services_len = health_human_services
			.length();

	public static final String SUBSIDARIES_SEARCH_TXT = "<tr><th>subsidiaries</th><td>";
	public static final int SUBSIDARIES_SEARCH_TXT_LEN = SUBSIDARIES_SEARCH_TXT
			.length();

	public static String getFileAsString(String filePath) throws Exception {
		byte[] encoded = Files.readAllBytes(Paths.get(filePath));
		return new String(encoded, StandardCharsets.UTF_8);

	}

	public static List<String> getSubsidariesList(String companyInfoJson) {
		List<String> subsidariesList = new ArrayList<String>();

		Map<String, Object> companyInfoMap = ObjectConversionUtils
				.jsonToMap(new JSONObject(companyInfoJson));

		subsidariesList = cleanupTheEntries(companyInfoMap.get("subsidiaries")
				.toString().split("\" \""));
		System.out.println("Subsidaries for company\t:"
				+ companyInfoMap.get("company_name"));
		for (String subsidary : subsidariesList) {
			System.out.println(subsidary);

		}
		return subsidariesList;
	}

	private static List<String> cleanupTheEntries(String[] entries) {
		List<String> processedArray = new ArrayList<String>();
		if (entries != null && entries.length > 0) {

			for (String entry : entries) {
				processedArray.add(entry.replace("\"", "").replace("[", "")
						.replace("]", "").trim());

			}

		}

		return processedArray;
	}

	public static void main(String[] args) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		// get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		System.out.println(Calendar.getInstance().toString());
		Map<String, String> corporateMatchingInfoDBCache = new HashMap<>();
		// String fileContents = FilesExtractor
		// .getFileAsString("/Users/administrator/Desktop/sample_all_content.txt");
		String fileContents = FilesExtractor
				.getFileAsString("/Users/administrator/Documents/pyfund/all_content.txt");
		List<Integer> tableStartIndices = new ArrayList<Integer>();
		int startIndex = fileContents.indexOf(SEO_TEXT);

		while (startIndex > 0) {
			tableStartIndices.add(startIndex + SEO_TEXT_LENGTH);
			startIndex = fileContents.indexOf(SEO_TEXT, startIndex + 1);
		}

		List<Integer> tableEndIndices = new ArrayList<Integer>();
		int endIindex = fileContents.indexOf(TABLE_END);
		while (endIindex > 0) {
			tableEndIndices.add(endIindex + TABLE_END_LENGTH);
			endIindex = fileContents.indexOf(TABLE_END, endIindex + 1);
		}

		if (tableStartIndices.size() == tableEndIndices.size()) {
			System.out
					.println("VALIDATION PASSED. Found equal number of table start and table end indicies!");
			System.out
					.println("Number of corporate entries found in CONTENT file:\t"
							+ tableEndIndices.size());
			Collections.sort(tableStartIndices);
			Collections.sort(tableEndIndices);
			for (int i = 0; i < tableStartIndices.size(); i++) {

				String compantInfoJson = convertHTMLToJSON(fileContents
						.substring(tableStartIndices.get(i),
								tableEndIndices.get(i)).trim());

				// put company main info
				corporateMatchingInfoDBCache.put(
						getCompanyName(compantInfoJson).trim().toLowerCase(),
						compantInfoJson);

				List<String> subsidariesList = getSubsidariesList(compantInfoJson);

				// put subsidiaries info
				for (String subsidary : subsidariesList) {
					if (!corporateMatchingInfoDBCache.containsKey(subsidary
							.trim().toLowerCase()))
						corporateMatchingInfoDBCache.put(subsidary.trim()
								.toLowerCase(),
								"$"
										+ getCompanyName(compantInfoJson)
												.trim().toLowerCase());
				}

				// put formatted of the words
				for (String formattedWord : getFormattedWords(getCompanyName(
						compantInfoJson).trim().toLowerCase())) {

					if (!corporateMatchingInfoDBCache.containsKey(formattedWord
							.trim().toLowerCase()))
						corporateMatchingInfoDBCache.put(formattedWord.trim()
								.toLowerCase(),
								"_"
										+ getCompanyName(compantInfoJson)
												.trim().toLowerCase());

				}

				// put formatted of the words
				for (String formattedWord : getFormattedWords(subsidariesList)) {

					if (!corporateMatchingInfoDBCache
							.containsKey(formattedWord
									.trim().toLowerCase()))
						corporateMatchingInfoDBCache.put(formattedWord.trim()
								.toLowerCase(),
								"$"
										+ getCompanyName(compantInfoJson)
												.trim().toLowerCase());

				}

			}

		}

		System.out.println("No of companies in corp matching DB:\t"
				+ corporateMatchingInfoDBCache.keySet().size());
		System.out.println(Calendar.getInstance().toString());
		// get current date time with Calendar()
		Calendar cal1 = Calendar.getInstance();
		System.out.println(dateFormat.format(cal1.getTime()));
		FileWriter fw = new FileWriter(
				"/Users/administrator/Desktop/cm_db.json");
		fw.write(new JSONObject(corporateMatchingInfoDBCache).toString(4));
		fw.close();
		System.out
				.println(ObjectConversionUtils
						.toMap(new JSONObject(
								getFileAsString("/Users/administrator/Desktop/cm_db.json")))
						.get("Constellation Commodities Group"));

	}

	private static Set<String> getFormattedWords(List<String> names) {
		Set<String> formmatedWords = new HashSet<String>();
		for (String name : names) {
			formmatedWords.addAll(getFormattedWords(name));
		}
		return formmatedWords;
	}

	private static Set<String> getFormattedWords(String company) {
		Set<String> formmatedWords = new HashSet<String>();

		formmatedWords.add(company.replaceAll("[^\\p{Alpha}]+", "").trim());
		formmatedWords.add(company.replaceAll("[^\\p{Alpha}]+", " ").trim());
		formmatedWords.add(company.replaceAll(".", " ").trim());
		formmatedWords.add(company.replaceAll(".", "").trim());

		return formmatedWords;
	}

	private static String getCompanyName(String companyInfoJson) {
		Map<String, Object> companyInfoMap = ObjectConversionUtils
				.jsonToMap(new JSONObject(companyInfoJson));

		return companyInfoMap.get("company_name").toString();
	}

	private static String convertHTMLToJSON(String content) {
		Map<String, String> dataJson = new HashMap<String, String>();
		dataJson.put("heading", content.substring(content.indexOf(HEADING)
				+ HEADING_LENGTH, content.indexOf(HEADING_END)));

		int part_time_eligible_end = content.indexOf(part_time_eligible)
				+ part_time_eligible_len;
		dataJson.put(
				"part_time_eligible",
				content.substring(part_time_eligible_end,
						content.indexOf(ROW_END, part_time_eligible_end)));

		int intranet_forms_end = content.indexOf(intranet_forms)
				+ intranet_forms_len;
		dataJson.put(
				"intranet_forms",
				content.substring(intranet_forms_end,
						content.indexOf(ROW_END, intranet_forms_end)));

		int data_provider_name_end = content.indexOf(data_provider_name)
				+ data_provider_name_len;
		dataJson.put(
				"data_provider_name",
				content.substring(data_provider_name_end,
						content.indexOf(ROW_END, data_provider_name_end)));

		int matching_gift_offered_end = content.indexOf(matching_gift_offered)
				+ matching_gift_offered_len;
		dataJson.put(
				"matching_gift_offered",
				content.substring(matching_gift_offered_end,
						content.indexOf(ROW_END, matching_gift_offered_end)));

		int corporate_contact_email_end = content
				.indexOf(corporate_contact_email) + corporate_contact_email_len;
		dataJson.put(
				"corporate_contact_email",
				content.substring(corporate_contact_email_end,
						content.indexOf(ROW_END, corporate_contact_email_end)));

		int higher_ed_end = content.indexOf(higher_ed) + higher_ed_len;
		dataJson.put(
				"higher_ed",
				content.substring(higher_ed_end,
						content.indexOf(ROW_END, higher_ed_end)));

		int minimum_matched_end = content.indexOf(minimum_matched)
				+ minimum_matched_len;
		dataJson.put(
				"minimum_matched",
				content.substring(minimum_matched_end,
						content.indexOf(ROW_END, minimum_matched_end)));

		int k12_end = content.indexOf(k12) + k12_len;
		dataJson.put("k12",
				content.substring(k12_end, content.indexOf(ROW_END, k12_end)));

		int volunteer_minimum_hours_required_end = content
				.indexOf(volunteer_minimum_hours_required)
				+ volunteer_minimum_hours_required_len;
		dataJson.put("volunteer_minimum_hours_required", content.substring(
				volunteer_minimum_hours_required_end,
				content.indexOf(ROW_END, volunteer_minimum_hours_required_end)));

		int intranet_guidelines_end = content.indexOf(intranet_guidelines)
				+ intranet_guidelines_len;
		dataJson.put(
				"intranet_guidelines",
				content.substring(intranet_guidelines_end,
						content.indexOf(ROW_END, intranet_guidelines_end)));

		int corporate_contact_name_end = content
				.indexOf(corporate_contact_name) + corporate_contact_name_len;

		dataJson.put(
				"corporate_contact_name",
				content.substring(corporate_contact_name_end,
						content.indexOf(ROW_END, corporate_contact_name_end)));

		int corporate_donation_offered_end = content
				.indexOf(corporate_donation_offered)
				+ corporate_donation_offered_len;
		dataJson.put("corporate_donation_offered", content.substring(
				corporate_donation_offered_end,
				content.indexOf(ROW_END, corporate_donation_offered_end)));

		int email_domains_end = content.indexOf(email_domains)
				+ email_domains_len;
		dataJson.put(
				"email_domains",
				content.substring(email_domains_end,
						content.indexOf(ROW_END, email_domains_end)));

		int all_nonprofits_end = content.indexOf(all_nonprofits)
				+ all_nonprofits_len;

		dataJson.put(
				"all_nonprofits",
				content.substring(all_nonprofits_end,
						content.indexOf(ROW_END, all_nonprofits_end)));

		int matching_gift_process_end = content.indexOf(matching_gift_process)
				+ matching_gift_process_len;
		dataJson.put(
				"matching_gift_process",
				content.substring(matching_gift_process_end,
						content.indexOf(ROW_END, matching_gift_process_end)));

		int company_name_end = content.indexOf(company_name) + company_name_len;
		dataJson.put(
				"company_name",
				content.substring(company_name_end,
						content.indexOf(ROW_END, company_name_end)));

		int flag_comment_end = content.indexOf(company_name) + company_name_len;
		dataJson.put(
				"flag_comment",
				content.substring(flag_comment_end,
						content.indexOf(ROW_END, flag_comment_end)));

		int corporate_contact_phone_end = content
				.indexOf(corporate_contact_phone) + corporate_contact_phone_len;
		dataJson.put(
				"corporate_contact_phone",
				content.substring(corporate_contact_phone_end,
						content.indexOf(ROW_END, corporate_contact_phone_end)));

		int full_time_eligible_end = content.indexOf(full_time_eligible)
				+ full_time_eligible_len;
		dataJson.put(
				"full_time_eligible",
				content.substring(full_time_eligible_end,
						content.indexOf(ROW_END, full_time_eligible_end)));

		int region_end = content.indexOf(region) + region_len;
		dataJson.put(
				"region",
				content.substring(region_end,
						content.indexOf(ROW_END, region_end)));

		int updated_at_end = content.indexOf(updated_at) + updated_at_len;
		dataJson.put(
				"updated_at",
				content.substring(updated_at_end,
						content.indexOf(ROW_END, updated_at_end)));

		int url_guidelines_end = content.indexOf(url_guidelines)
				+ url_guidelines_len;

		dataJson.put(
				"url_guidelines",
				content.substring(url_guidelines_end,
						content.indexOf(ROW_END, url_guidelines_end)));

		int url_forms_end = content.indexOf(url_forms) + url_forms_len;
		dataJson.put(
				"url_forms",
				content.substring(url_forms_end,
						content.indexOf(ROW_END, url_forms_end)));

		int retirees_eligible_end = content.indexOf(retirees_eligible)
				+ retirees_eligible_len;
		dataJson.put(
				"retirees_eligible",
				content.substring(retirees_eligible_end,
						content.indexOf(ROW_END, retirees_eligible_end)));

		int status_end = content.indexOf(status) + status_len;
		dataJson.put(
				"status",
				content.substring(status_end,
						content.indexOf(ROW_END, status_end)));

		int ratio_end = content.indexOf(ratio) + ratio_len;
		dataJson.put(
				"ratio",
				content.substring(ratio_end,
						content.indexOf(ROW_END, ratio_end)));

		int id_end = content.indexOf(id) + id_len;
		dataJson.put("id",
				content.substring(id_end, content.indexOf(ROW_END, id_end)));

		int subsidiaries_end = content.indexOf(subsidiaries) + subsidiaries_len;
		dataJson.put(
				"subsidiaries",
				content.substring(subsidiaries_end,
						content.indexOf(ROW_END, subsidiaries_end)));

		int environmental_end = content.indexOf(environmental)
				+ environmental_len;
		dataJson.put(
				"environmental",
				content.substring(environmental_end,
						content.indexOf(ROW_END, environmental_end)));

		int data_provider_email_end = content.indexOf(data_provider_email)
				+ data_provider_email_len;
		dataJson.put(
				"data_provider_email",
				content.substring(data_provider_email_end,
						content.indexOf(ROW_END, data_provider_email_end)));

		int maximum_matched_end = content.indexOf(maximum_matched)
				+ maximum_matched_len;
		dataJson.put(
				"maximum_matched",
				content.substring(maximum_matched_end,
						content.indexOf(ROW_END, maximum_matched_end)));

		int civic_community_end = content.indexOf(civic_community)
				+ civic_community_len;
		dataJson.put(
				"civic_community",
				content.substring(civic_community_end,
						content.indexOf(ROW_END, civic_community_end)));

		int volunteer_grant_process_end = content
				.indexOf(volunteer_grant_process) + volunteer_grant_process_len;
		dataJson.put(
				"volunteer_grant_process",
				content.substring(volunteer_grant_process_end,
						content.indexOf(ROW_END, volunteer_grant_process_end)));

		int volunteer_grant_offered_end = content
				.indexOf(volunteer_grant_offered) + volunteer_grant_offered_len;
		dataJson.put(
				"volunteer_grant_offered",
				content.substring(volunteer_grant_offered_end,
						content.indexOf(ROW_END, volunteer_grant_offered_end)));

		int health_human_services_end = content.indexOf(health_human_services)
				+ health_human_services_len;
		dataJson.put(
				"health_human_services",
				content.substring(health_human_services_end,
						content.indexOf(ROW_END, health_human_services_end)));

		return ObjectConversionUtils.mapToJson(dataJson);

	}
}
