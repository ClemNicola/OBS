package com.obs.OBS.core.indexation;

import com.obs.OBS.company.Company;
import com.obs.OBS.company.CompanyDAO;
import com.obs.OBS.company.CompanyMapper;
import com.obs.OBS.elasticSearch.Document.CompanyDocument;
import com.obs.OBS.elasticSearch.Document.JobOfferDocument;
import com.obs.OBS.elasticSearch.Document.SeekerDocument;
import com.obs.OBS.jobOffer.JobDAO;
import com.obs.OBS.jobOffer.JobMapper;
import com.obs.OBS.jobOffer.JobOffer;
import com.obs.OBS.jobSeeker.Seeker;
import com.obs.OBS.jobSeeker.SeekerDAO;
import com.obs.OBS.jobSeeker.SeekerMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexationServiceImpl implements IndexationService {
  private final CompanyDAO companyDAO;
  private final CompanyMapper companyMapper;

  private final JobDAO jobDAO;
  private final JobMapper jobMapper;

  private final SeekerDAO seekerDAO;
  private final SeekerMapper seekerMapper;

  @Override
  @Scheduled(cron = "0 */15 * * * *")
  public void indexFull() {
    indexCompanies();
    indexSeekers();
    indexJobOffers();
  }

  @Override
  public void indexCompanies() {
    List<Company> companies = companyDAO.getAll();
    List<CompanyDocument> companyDocuments = companies.stream()
        .map(companyMapper::toDocument)
        .toList();
    companyDAO.deleteAll();
    companyDAO.saveAll(companyDocuments);
    log.info("Indexation des entreprises réussie");
  }

  @Override
  public void indexSeekers() {
    List<Seeker> seekers = seekerDAO.getAll();
    List<SeekerDocument> seekerDocuments = seekers.stream()
        .map(seekerMapper::toDocument)
        .toList();
    seekerDAO.deleteAll();
    seekerDAO.saveAll(seekerDocuments);
    log.info("Indexation des jobSeekers réussie");
  }

  @Override
  public void indexJobOffers() {
    List<JobOffer> jobOffers = jobDAO.getAll();
    List<JobOfferDocument> jobOfferDocuments = jobOffers.stream()
        .map(jobMapper::toDocument)
        .toList();
    jobDAO.deleteAll();
    jobDAO.saveAll(jobOfferDocuments);
    log.info("Indexation des job réussie");
  }
}
